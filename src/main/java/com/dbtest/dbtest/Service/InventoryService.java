package com.dbtest.dbtest.Service;

import com.dbtest.dbtest.Entity.Inventory;
import com.dbtest.dbtest.Entity.ProductEntity;
import com.dbtest.dbtest.Entity.Subproduct;
import com.dbtest.dbtest.Entity.VendorEntity;
import com.dbtest.dbtest.Repository.InventoryRepo;
import com.dbtest.dbtest.Repository.ProductRepo;
import com.dbtest.dbtest.Repository.SubProductRepo;
import com.dbtest.dbtest.Repository.VendorRepo;
import com.dbtest.dbtest.Schema.InventoryRequest;
import com.dbtest.dbtest.Schema.InventoryResponse;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class InventoryService {
    public static final String CREATED_BY = "Arijeet";
    public static final String LAST_UPDATED_BY = "Arijeet";
    @Autowired
    public VendorRepo vendorRepo;
    @Autowired
    public ProductRepo productRepo;
    @Autowired
    public SubProductRepo subProductRepo;
    @Autowired
    public InventoryRepo inventoryRepo;


    public InventoryResponse addIntoInventory(String productTypeReq, String stockLocationReq, String productNameReq, String subProductNameReq, int quantityReq, String vendorNameReq) {

        InventoryResponse inventoryResponse = new InventoryResponse();

        ProductEntity productEntity = productRepo.findByproductName(productNameReq);
        if (!Objects.nonNull(productEntity)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request - Product Name not Valid ");
        }
        Subproduct subproduct = subProductRepo.findBysubProductName(subProductNameReq);
        if (!Objects.nonNull(subproduct)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request - Sub-Product Name not Valid ");
        }
        VendorEntity vendorEntity = vendorRepo.findByvendorName(vendorNameReq);
        if (!Objects.nonNull(vendorEntity)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request - Vendor Name not Valid ");
        }
            Inventory inventory = inventoryRepo.findByProductDetailsAndSubProductDetailsAndVendorDetails(productEntity, subproduct, vendorEntity);

            if (!Objects.nonNull(inventory)) {
                addDetails(productTypeReq, stockLocationReq, productNameReq, subProductNameReq, quantityReq, vendorNameReq);
                inventoryResponse.message = "added to inventory";

            } else {
                if (Objects.equals(inventory.getQuantity(), quantityReq) && Objects.equals(inventory.getStocklocation(), stockLocationReq )&& Objects.equals(inventory.getProductType(),productTypeReq )) {
                    inventoryResponse.message = "No Update made to the DB since the request data already exists in the DB";
                } else {
                    inventoryRepo.updatestocklocation(stockLocationReq, subproduct);
                    inventoryRepo.updatequantity(quantityReq, subproduct);
                    inventory.setProductType(productTypeReq);
                    Double purchasePrice = quantityReq * subproduct.getProductPurchasePrice();
                    Double sellingPrice = quantityReq * subproduct.getProductSellingPrice();
                    inventoryRepo.updateproductPurchasePrice(purchasePrice, subproduct);
                    inventoryRepo.updateproductSellingPrice(sellingPrice, subproduct);
                    inventoryRepo.updatelastUpdatedTimestamp(LocalDateTime.now(), subproduct);
                    inventoryRepo.updatelastUpdatedBy(LAST_UPDATED_BY, subproduct);
                    inventoryRepo.save(inventory);
                    inventoryResponse.message = "The record updated successfully";
                }

            }
            return inventoryResponse;
        }

//


        private void addDetails (String productTypeReq, String stockLocationReq, String productNameReq, String subProductNameReq,int quantityReq, String vendorNameReq){
            Inventory inventory = new Inventory();

            ProductEntity productDetails = productRepo.findByproductName(productNameReq);
            Subproduct subproductDetails = subProductRepo.findBysubProductName(subProductNameReq);
            VendorEntity vendorDetails = vendorRepo.findByvendorName(vendorNameReq);

            inventory.setProductType(productTypeReq);
            inventory.setStocklocation(stockLocationReq);
            inventory.setProductDetails(productDetails);
            inventory.setSubProductDetails(subproductDetails);
            inventory.setQuantity(quantityReq);
            Double purchasePrice = quantityReq * subproductDetails.getProductPurchasePrice();
            inventory.setProductPurchasePrice(purchasePrice);
            Double sellingPrice = quantityReq * subproductDetails.getProductSellingPrice();
            inventory.setProductSellingPrice(sellingPrice);
            inventory.setVendorDetails(vendorDetails);
            inventory.setCreatedByTimestamp(LocalDateTime.now());
            inventory.setCreatedBy(CREATED_BY);
            inventoryRepo.save(inventory);
        }
    }
