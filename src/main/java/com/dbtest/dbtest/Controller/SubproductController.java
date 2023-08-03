package com.dbtest.dbtest.Controller;

import com.dbtest.dbtest.Schema.SubProductResponse;
import com.dbtest.dbtest.Schema.SubProductSchema;
import com.dbtest.dbtest.Service.SubProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubproductController {

    @Autowired
    public SubProductService subProductService;

    @PostMapping("/SubProduct")
    public SubProductResponse AddSubProduct(@RequestBody SubProductSchema subProductSchema){
       return subProductService.addSubProduct(subProductSchema);
    }
    @PutMapping("/SubProduct")
    public SubProductResponse UpdateSubproduct(@RequestBody SubProductSchema subProductSchema){
        return subProductService.updateSubproduct(subProductSchema);
    }
}

