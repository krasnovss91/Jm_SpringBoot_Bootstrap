package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.model.User;
import com.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;


    @Autowired
    public AdminController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", userService.getAllUsers());
        return "admin";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit-user";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user, Model model){
        userService.editUser(user);
        model.addAttribute("user", user);
        return "redirect:/admin";
    }

/*
    @PostMapping(value = "/delete", params = "id")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
 */
@RequestMapping(value = "/delete", params = "id")
public String deleteUser(@RequestParam("id") long id) {
    userService.deleteUser(id);
    return "redirect:/admin";
}
}
