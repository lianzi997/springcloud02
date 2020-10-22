package com.ribbon.ribbon.contreller;

import com.ribbon.ribbon.entity.Product;
import com.ribbon.ribbon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public Object products(Model m) {
        System.out.println("controller --------");
        List<Product> ps = productService.listProducts();
        m.addAttribute("ps", ps);
        return "products";
    }
}
