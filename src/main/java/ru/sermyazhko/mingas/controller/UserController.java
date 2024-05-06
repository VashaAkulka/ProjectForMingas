package ru.sermyazhko.mingas.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sermyazhko.mingas.dto.UserDTO;
import ru.sermyazhko.mingas.service.UserService;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    @GetMapping
    public String addFormUser() {
        return "new-user";
    }

    @PostMapping
    public String addOrFindUser(@ModelAttribute UserDTO user) {
        return "redirect:/agreement/" + service.addOrFindUser(user).getId();
    }

    @GetMapping("/all")
    public String getAllUser(Model model) {
        model.addAttribute("users", service.getAllUser());
        return "users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        service.deleteUser(id);
        return "redirect:/user/all";
    }

    @GetMapping("/update/{id}")
    public String updateFormUser(@PathVariable("id") Long id,
                                 Model model) {
        model.addAttribute("user", service.getById(id));
        return "update-user";
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable("id") Long id,
                             @ModelAttribute UserDTO user) {

        service.updateUser(user, id);
        return "redirect:/user/all";
    }
}
