package com.dbtest.dbtest.Service;

import com.dbtest.dbtest.Entity.ProductEntity;
import com.dbtest.dbtest.Entity.Subproduct;
import com.dbtest.dbtest.Entity.VendorEntity;
import com.dbtest.dbtest.Repository.ProductRepo;
import com.dbtest.dbtest.Repository.SubProductRepo;
import com.dbtest.dbtest.Repository.VendorRepo;
import com.dbtest.dbtest.Schema.SubProductResponse;
import com.dbtest.dbtest.Schema.SubProductSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Service
public class SubProductService {
    @Autowired
     public ProductRepo productRepo;

    @Autowired
    public VendorRepo vendorRepo;

    @Autowired
    public SubProductRepo subProductRepo;

    SubProductResponse subProductResponse= new SubProductResponse();

    String lastUpdatedBy= "Utkarsha";

    String createdBy= "Utkarsha";


public SubProductResponse addSubProduct(SubProductSchema subProductSchema) {
    Subproduct subproduct = subProductRepo.findBysubProductName(subProductSchema.subProductName);
    // if subproduct found is null new record will be added otherwise record willbe updated
    if (subproduct == null) {
        addSubProductinDb(subProductSchema.subProductName, subProductSchema.productName, subProductSchema.vendorName, subProductSchema.productSellingPrice, subProductSchema.productPurchasePrice);
        subProductResponse.message = "SubProduct added successfully";
        subProductResponse.YourSubproductID=subproduct.getSubProductId();
    } else {
        subProductResponse.message = "SubProduct already exists please update successfully";
        subProductResponse.YourSubproductID=subproduct.getSubProductId();
    }

    return subProductResponse;
}


    private void addSubProductinDb(String subProductName, String productName, String vendorName, float productSellingPrice, float productPurchasePrice) {

        Subproduct subproduct=new Subproduct();
        //product id = query to find product Name get product id
        subproduct.setProductDetails(productRepo.findByproductName(productName));

        //vendor name = query to find vendor id
        subproduct.setVendorDetails(vendorRepo.findByvendorName(vendorName));

        subproduct.setSubProductName(subProductName);

        subproduct.setProductSellingPrice(productSellingPrice);

        subproduct.setProductPurchasePrice(productPurchasePrice);

        subproduct.setCreatedByTimestamp(LocalDateTime.now());

        subproduct.setLastUpdatedTimestamp(LocalDateTime.now());

        subproduct.setCreatedBy(createdBy);

        subproduct.setLastUpdatedBy(lastUpdatedBy);

        subProductRepo.save(subproduct);

    }

    public SubProductResponse updateSubproduct(SubProductSchema subProductSchema ){
        Subproduct subproduct = subProductRepo.findBysubProductId(subProductSchema.subproductId);
        boolean attributesChanged = false;

        // Check if any of the attributes have changed
        if (!subproduct.getProductDetails().getProductName().equals(subProductSchema.productName)) {
            ProductEntity prod=productRepo.findByproductName(subProductSchema.productName);
            if(prod==null){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Product with ProductName found. Plese add Subproduct first");
            }
            else{
                subproduct.setProductDetails(prod);
            }
            attributesChanged = true;
        }
        if (!subproduct.getVendorDetails().getVendorName().equals(subProductSchema.vendorName)) {
            VendorEntity vend=vendorRepo.findByvendorName(subProductSchema.vendorName);
            if (vend == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Vendor with VendorName found. Please add Subproduct first");
            }
            else {
                subproduct.setVendorDetails(vend);
            }
            attributesChanged = true;
        }
        if (subproduct.getProductSellingPrice()!=(subProductSchema.productSellingPrice)) {
            subproduct.setProductSellingPrice(subProductSchema.productSellingPrice);
            attributesChanged = true;
        }
        if (subproduct.getProductPurchasePrice()!=subProductSchema.productPurchasePrice) {
            subproduct.setProductPurchasePrice(subProductSchema.productPurchasePrice);
            attributesChanged = true;
        }

        if (attributesChanged==true) {
            // Update the lastUpdatedBy and lastUpdatedTimestamp
            subproduct.setLastUpdatedBy(lastUpdatedBy);
            subproduct.setLastUpdatedTimestamp(LocalDateTime.now());

            // Save the updated subproduct in the database
            subProductRepo.save(subproduct);
            subProductResponse.message = "Subproduct attributes updated";
            subProductResponse.YourSubproductID=subproduct.getSubProductId();
        } else if (attributesChanged==false) {
            subProductResponse.message = "Subproduct already exists in the database with the same attributes";
            subProductResponse.YourSubproductID=subproduct.getSubProductId();
        }
        return  subProductResponse;
    }
}
