package example.controllers;

import example.models.Product;
import example.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("products")
public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public String addProduct(@RequestParam String name,
                             @RequestParam Double price,
                             @RequestParam Double id,
                           Model page) {
        Product product = new Product();
        product.setName(name);
        product.setId(id);
        product.setPrice(price);
        service.addProduct(product);

        List<Product> list = service.findAll();
        page.addAttribute("products", list);
        return "products.html";
    }
    @GetMapping
    public String findAll(Model page) {
        List<Product> products = service.findAll();
        page.addAttribute("products", products);
        return "products.html";
    }

    @PostMapping("/delete")
    public String delete(Model page,@RequestParam Double id) {
        service.delete(id);
        List<Product> products = service.findAll();
        page.addAttribute("products", products);
        return "products.html";
    }
}
