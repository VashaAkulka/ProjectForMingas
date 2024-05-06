package ru.sermyazhko.mingas.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sermyazhko.mingas.dto.AgreementDTO;
import ru.sermyazhko.mingas.service.AgreementService;

import java.time.LocalDateTime;

@Controller
@AllArgsConstructor
@RequestMapping("/agreement")
public class AgreementController {
    private AgreementService service;

    @GetMapping
    public String addFormAgreement() {
        return "new-agreement";
    }

    @PostMapping
    public String addAgreement(@ModelAttribute AgreementDTO agreement) {
        service.addAgreement(agreement);
        return "redirect:/agreement/all";
    }

    @GetMapping("/all")
    public String getAllAgreement(Model model) {
        model.addAttribute("agreements", service.getAllAgreement());
        return "agreements";
    }

    @DeleteMapping("/{id}")
    public String deleteAgreement(@PathVariable("id") Long id) {
        service.deleteAgreement(id);
        return "redirect:/agreement/all";
    }

    @GetMapping("/{userId}")
    public String getNotConsentAgreementByUser(@PathVariable("userId") Long userId,
                                               Model model) {
        model.addAttribute("agreements", service.getNotConsentAgreementByUser(userId));
        model.addAttribute("userId", userId);
        return "user-noAgree-agreement";
    }

    @GetMapping("/update/{id}")
    public String updateFormAgreement(@PathVariable("id") Long id,
                                      Model model) {
        model.addAttribute("agreement", service.getById(id));
        return "update-agreement";
    }

    @PatchMapping("/{id}")
    public String updateAgreement(@PathVariable("id") Long id,
                                  @ModelAttribute AgreementDTO agreement) {

        service.updateAgreement(agreement, id);
        return "redirect:/agreement/all";
    }
}
