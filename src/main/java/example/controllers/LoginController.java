package example.controllers;

import example.models.User;
import example.services.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final LoginProcessor loginProcessor;
    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }
    @GetMapping
    public String login() {
        return "login.html";
    }

    @PostMapping
    public String login(@RequestParam String name, @RequestParam String password, Model page) {
        loginProcessor.setName(name);
        loginProcessor.setPassword(password);
        boolean isAuthSuccessfull = loginProcessor.login();
        if(isAuthSuccessfull) {
            return "redirect:/main";
        }
        page.addAttribute("message", "Login failed!");
        return "login.html";
    }
}
