package example.controllers;

import example.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class IndexController
{
    @GetMapping
    public String getHello() {

        return "Index.html";
    }
}
