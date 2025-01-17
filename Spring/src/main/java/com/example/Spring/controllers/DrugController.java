package com.example.Spring.controllers;

import com.example.Spring.entities.Drug;
import com.example.Spring.services.DrugService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/drugs")
public class DrugController {

    private final DrugService drugService;

    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping
    public String listDrugs(Model model) {
        model.addAttribute("drugs", drugService.findAll());
        return "drugs";
    }

    @PostMapping
    public String saveDrug(@ModelAttribute Drug drug) {
        drugService.save(drug);
        return "redirect:/drugs";
    }
}
