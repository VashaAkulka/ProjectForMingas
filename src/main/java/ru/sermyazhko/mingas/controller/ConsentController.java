package ru.sermyazhko.mingas.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sermyazhko.mingas.dto.ConsentDTO;
import ru.sermyazhko.mingas.service.ConsentService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@AllArgsConstructor
@RequestMapping("/consent")
public class ConsentController {
    private final ConsentService service;

    @GetMapping("/{userId}")
    public String getUserConsent(@PathVariable("userId") Long id,
                                 Model model) {

        model.addAttribute("consents", service.getUserConsent(id));
        return "user-consent";
    }

    @DeleteMapping("/{userId}/{id}")
    public String deleteConsent(@PathVariable("id") Long id,
                                @PathVariable("userId") Long userId) {
        service.deleteConsent(id);
        return "redirect:/consent/" + userId;
    }

    @PostMapping("/{userId}/{agreementId}")
    public String addConsent(@PathVariable("userId") Long userId,
                             @PathVariable("agreementId") Long agreementId,
                             @ModelAttribute ConsentDTO consent) {

        consent.setUserId(userId);
        consent.setAgreementId(agreementId);
        consent.setFromDate(LocalDate.now());
        service.addConsent(consent);
        return "redirect:/agreement/" + userId;
    }
}
