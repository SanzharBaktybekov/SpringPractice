package example.controllers;

import example.services.LoggedUserManagementService;
import example.services.LoginCountService;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/main")
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;
    public MainController(LoggedUserManagementService loggedUserManagementService,
                          LoginCountService loginCountService) {
        this.loginCountService = loginCountService;
        this.loggedUserManagementService = loggedUserManagementService;
    }
    @GetMapping
    public String main(@RequestParam(required = false) String Logout, Model page) {

        if(Logout != null) {
            loggedUserManagementService.setName(null);
        }
        String username = loggedUserManagementService.getName();
        page.addAttribute("name", username);
        page.addAttribute("loginCount", loginCountService.getCount());
        if(username == null) {
            return "redirect:/";
        }
        return "main.html";
    }

}
