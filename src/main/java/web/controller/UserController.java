package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping(value = "/adduser")
    public String newUser(@ModelAttribute("user") User user) {
        return "adduser";
    }
    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/edituser")
    public String editUser(Model model, @RequestParam long id) {
        model.addAttribute("user", userService.getUser(id));
        return "edituser";
    }
    @PostMapping("/edituser/edit")
    public String editUser(@ModelAttribute("user") User user, @RequestParam long id) {
        userService.updateUser(id, user);
        return "redirect:/";
    }

    @PostMapping("/deleteuser")
    public String deleteUser(@RequestParam long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
