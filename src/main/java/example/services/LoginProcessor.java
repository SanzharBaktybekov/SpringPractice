package example.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;
    public LoginProcessor(LoggedUserManagementService loggedUserManagementService,
                          LoginCountService loginCountService) {
        this.loginCountService = loginCountService;
        this.loggedUserManagementService = loggedUserManagementService;
    }
    private String name;
    private String password;

    public boolean login() {
        loginCountService.increment();
        if("Sanzhar".equals(name) && "password".equals(password)) {
            loggedUserManagementService.setName(name);
            return true;
        } else {
            return false;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
