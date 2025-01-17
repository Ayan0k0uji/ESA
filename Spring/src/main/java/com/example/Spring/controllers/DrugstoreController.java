package com.example.Spring.controllers;

import com.example.Spring.entities.Drugstore;
import com.example.Spring.services.DrugstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drugstores")
public class DrugstoreController {

    private final DrugstoreService drugstoreService;

    @Autowired
    public DrugstoreController(DrugstoreService drugstoreService) {
        this.drugstoreService = drugstoreService;
    }

    @GetMapping
    public String listDrugstores(Model model) {
        model.addAttribute("drugstores", drugstoreService.findAll());
        return "drugstores";
    }

    @PostMapping
    public String saveDrugstore(@ModelAttribute Drugstore drugstore) {
        drugstoreService.save(drugstore);
        return "redirect:/drugstores";
    }
}
