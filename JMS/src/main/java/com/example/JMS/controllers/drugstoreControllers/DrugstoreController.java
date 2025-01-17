package com.example.JMS.controllers.drugstoreControllers;

import com.example.JMS.services.DrugstoreService;
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
@RequestMapping("/drugstores")
public class DrugstoreController {

    private final DrugstoreService drugstoreService;
    private final ResourceLoader resourceLoader;


    @Autowired
    public DrugstoreController(DrugstoreService drugstoreService, ResourceLoader resourceLoader) {
        this.drugstoreService = drugstoreService;
        this.resourceLoader = resourceLoader;
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String getDrugstores() throws TransformerException, IOException {
        String xmlData = drugstoreService.getAsXml();

        Resource xslResource = resourceLoader.getResource("classpath:templates/drugstores.xsl");
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
