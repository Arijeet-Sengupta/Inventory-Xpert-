package com.dbtest.dbtest.Controller;

import com.dbtest.dbtest.Schema.InventoryResponse;
import com.dbtest.dbtest.Schema.LoginResponse;
import com.dbtest.dbtest.Service.InventoryService;
import com.dbtest.dbtest.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {
    @Autowired
    public InventoryService inventoryService;


    @PostMapping("/Inventory")
    public InventoryResponse postInventory(@RequestParam("productType") String productType,
                                           @RequestParam("stockLocation") String stockLocation,
                                           @RequestParam("productName") String producName,
                                           @RequestParam("subProductName") String subProductName,
                                           @RequestParam("quantity") int quantity,
                                           @RequestParam("vendorName") String vendorName) {

        return inventoryService.addIntoInventory(productType, stockLocation, producName, subProductName, quantity, vendorName);
    }


}
