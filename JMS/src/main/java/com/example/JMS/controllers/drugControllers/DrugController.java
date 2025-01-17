package com.example.JMS.controllers.drugControllers;

import com.example.JMS.services.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringWriter;

@RestController
@RequestMapping("/drugs")
public class DrugController {

    private final DrugService drugService;
    private final ResourceLoader resourceLoader;

    @Autowired
    public DrugController(DrugService drugService, ResourceLoader resourceLoader) {
        this.drugService = drugService;
        this.resourceLoader = resourceLoader;
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String getDrugs() throws IOException, TransformerException {
        String xmlData = drugService.getAsXml();

        Resource xslResource = resourceLoader.getResource("classpath:templates/drugs.xsl");
        StreamSource xslStreamSource = new StreamSource(xslResource.getInputStream());

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(xslStreamSource);

        StreamSource xmlStreamSource = new StreamSource(new java.io.StringReader(xmlData));
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);

        transformer.transform(xmlStreamSource, result);

        return writer.toString();
    }

}
