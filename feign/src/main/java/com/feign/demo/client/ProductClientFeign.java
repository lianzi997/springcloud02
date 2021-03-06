package com.feign.demo.client;


import com.feign.demo.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "client01")
public interface ProductClientFeign {

    @GetMapping("/products")
    public List<Product> listProdcuts();
}