package com.feign.demo.service;


import com.feign.demo.client.ProductClientFeign;
import com.feign.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductClientFeign productClientFeign;

    public List<Product> listProducts(){
         //return productClientFeign.listProdcuts();
        return productClientFeign.listProdcuts();

    }
}
