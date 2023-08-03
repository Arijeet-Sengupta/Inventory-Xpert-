package com.dbtest.dbtest.Controller;

import com.dbtest.dbtest.Entity.ProductEntity;
import com.dbtest.dbtest.Repository.ProductRepo;
import com.dbtest.dbtest.Schema.ProductResponse;
import com.dbtest.dbtest.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController

public class ProductController {

    @Autowired
    public ProductService productService;
    @Autowired
    public ProductRepo productRepo;

    //adding details
    @PostMapping("/adddetails")
    public ProductResponse createProduct (@RequestParam("productname")String productname)
    {

        return productService.addProduct(productname);
    }




}
