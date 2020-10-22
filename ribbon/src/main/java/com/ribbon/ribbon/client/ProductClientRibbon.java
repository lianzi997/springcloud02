package com.ribbon.ribbon.client;

import com.ribbon.ribbon.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProductClientRibbon {

    @Autowired
    RestTemplate restTemplate;

    public List<Product> listProdcuts() {
        System.out.println("hello listProducts");
        return restTemplate.getForObject("http://client01/products",List.class);
    }

}