package com.dbtest.dbtest.Controller;

import com.dbtest.dbtest.Schema.InventoryResponse;
import com.dbtest.dbtest.Schema.LoginResponse;
import com.dbtest.dbtest.Service.InventoryService;
import com.dbtest.dbtest.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class InventoryController {
    @Autowired
    public InventoryService inventoryService;

    /**
     * This for adding new details by postMapping
     * @param productType
     * @param stockLocation
     * @param producName
     * @param subProductName
     * @param quantity
     * @param vendorName
     * @return addIntoInventory of Inventory Response class with the req fields
     */
    @PostMapping("/Inventory")
    public InventoryResponse postInventory(@Validated @RequestParam("productType") String productType,
                                           @Validated @RequestParam("stockLocation") String stockLocation,
                                           @Validated @RequestParam("productName") String producName,
                                           @Validated @RequestParam("subProductName") String subProductName,
                                           @Validated @RequestParam("quantity") int quantity,
                                           @Validated @RequestParam("vendorName") String vendorName) {

        return inventoryService.addIntoInventory(productType, stockLocation, producName, subProductName, quantity, vendorName);
    }

    @PutMapping("/Inventory")
    public InventoryResponse updateInventory(@Validated @RequestParam("productType") String productType,
                                             @Validated @RequestParam("stockLocation") String stockLocation,
                                             @Validated @RequestParam("productName") String producName,
                                             @Validated @RequestParam("subProductName") String subProductName,
                                             @Validated @RequestParam("quantity") int quantity,
                                             @Validated @RequestParam("idToUpdate") int idToUpdate,
                                             @Validated @RequestParam("vendorName") String vendorName) {

        return inventoryService.updateIntoInventory(productType, stockLocation, producName, subProductName, quantity, idToUpdate, vendorName);


    }
}
