package com.dbtest.dbtest.Controller;

import com.dbtest.dbtest.Schema.SubProductResponse;
import com.dbtest.dbtest.Schema.SubProductSchema;
import com.dbtest.dbtest.Service.SubProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubproductController {

    @Autowired
    public SubProductService subProductService;
    //Post Mapping for adding Subproduct in database
    @PostMapping("/SubProduct")
    public SubProductResponse AddSubProduct(@Validated @RequestBody SubProductSchema subProductSchema){
       return subProductService.addSubProduct(subProductSchema);
    }
    //Put Mapping for updating details of Subproduct in database
    @PutMapping("/SubProduct")
    public SubProductResponse UpdateSubproduct(@Validated @RequestBody SubProductSchema subProductSchema){
        return subProductService.updateSubproduct(subProductSchema);
    }
}

