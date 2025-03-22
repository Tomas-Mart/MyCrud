package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/add")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user"; // Возвращаем на страницу с ошибками
        }
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit-user";
    }

    @PostMapping("/update")
    public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "edit-user"; // Возвращаем на страницу с ошибками
        }
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}