package com.ribbon.ribbon.service;

import com.ribbon.ribbon.client.ProductClientFeign;
import com.ribbon.ribbon.client.ProductClientRibbon;
import com.ribbon.ribbon.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductClientRibbon productClientRibbon;

    public List<Product> listProducts(){
         //return productClientFeign.listProdcuts();
        return productClientRibbon.listProdcuts();

    }
}
