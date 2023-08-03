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

//method to check if same product is available in database as provided in by user
public SubProductResponse addSubProduct(SubProductSchema subProductSchema) {
    ProductEntity prod = productRepo.findByproductName(subProductSchema.productName);
    VendorEntity vend = vendorRepo.findByvendorName(subProductSchema.vendorName);

    Subproduct subproduct= subProductRepo.findBySubProductNameAndProductDetailsAndVendorDetails(subProductSchema.subProductName,prod,vend);

    if(subproduct!=null) {
                subProductResponse.message = "SubProduct already exists";
                subProductResponse.YourSubproductID = subproduct.getSubProductId();
    }
    else {
        //add
        subProductResponse.message = "SubProduct added successfully";
        subProductResponse.YourSubproductID=addSubProductinDb(subProductSchema.subProductName, subProductSchema.productName, subProductSchema.vendorName, subProductSchema.productSellingPrice, subProductSchema.productPurchasePrice);

    }

    return  subProductResponse;
}

//Method to add Subproducts
    private int addSubProductinDb(String subProductName, String productName, String vendorName, Double productSellingPrice, Double productPurchasePrice) {

       Subproduct subproduct=new Subproduct();

        //finding record in product table for given product name if product with productname not found exception thrown
        ProductEntity prod = productRepo.findByproductName(productName);
        if(prod==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid ProductName found. Please add Product first");
        }
        else{
            subproduct.setProductDetails(productRepo.findByproductName(productName));
        }

        //finding record in vendor table for given Vendor name if vendername not found exception thrown

        VendorEntity vend = vendorRepo.findByvendorName(vendorName);
        if(vend==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid VendorName found. Please add Vendor first");
        }
        else {
            subproduct.setVendorDetails(vendorRepo.findByvendorName(vendorName));
        }

        subproduct.setSubProductName(subProductName);

        subproduct.setProductSellingPrice(productSellingPrice);

        subproduct.setProductPurchasePrice(productPurchasePrice);

        subproduct.setCreatedByTimestamp(LocalDateTime.now());

        subproduct.setLastUpdatedTimestamp(LocalDateTime.now());

        subproduct.setCreatedBy(createdBy);

        subproduct.setLastUpdatedBy(lastUpdatedBy);

        subProductRepo.save(subproduct);

        return subProductResponse.YourSubproductID=subproduct.getSubProductId();

    }

   //Method to update any subproduct
    public SubProductResponse updateSubproduct(SubProductSchema subProductSchema ){
    //find subproduct with Given id
        Subproduct subproduct = subProductRepo.findBysubProductId(subProductSchema.subproductId);
            // if subproduct is null
        if (subproduct ==null){
            subProductResponse.message = "Please Provide Valid Subproduct ID or Add Subproduct First";
            subProductResponse.YourSubproductID = subproduct.getSubProductId();
        }
            //if subproduct is found then update it
        else {
            boolean attributesChanged = false;

            // Check if any of the attributes have changed
            if (!subproduct.getProductDetails().getProductName().equals(subProductSchema.productName)) {
                ProductEntity prod = productRepo.findByproductName(subProductSchema.productName);
                if (prod == null) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Product with ProductName found. Please add Subproduct first");
                } else {
                    subproduct.setProductDetails(prod);
                }
                attributesChanged = true;
            }
            if (!subproduct.getVendorDetails().getVendorName().equals(subProductSchema.vendorName)) {
                VendorEntity vend = vendorRepo.findByvendorName(subProductSchema.vendorName);
                if (vend == null) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Vendor with VendorName found. Please add Subproduct first");
                } else {
                    subproduct.setVendorDetails(vend);
                }
                attributesChanged = true;
            }
            if (!subproduct.getProductSellingPrice().equals(subProductSchema.productSellingPrice)) {
                subproduct.setProductSellingPrice(subProductSchema.productSellingPrice);
                attributesChanged = true;
            }
            if (!subproduct.getProductPurchasePrice().equals(subProductSchema.productPurchasePrice)) {
                subproduct.setProductPurchasePrice(subProductSchema.productPurchasePrice);
                attributesChanged = true;
            }

            if (attributesChanged == true) {
                // Update the lastUpdatedBy and lastUpdatedTimestamp
                subproduct.setLastUpdatedBy(lastUpdatedBy);
                subproduct.setLastUpdatedTimestamp(LocalDateTime.now());

                // Save the updated subproduct in the database
                subProductRepo.save(subproduct);
                subProductResponse.message = "Subproduct attributes updated";
                subProductResponse.YourSubproductID = subproduct.getSubProductId();
            } else if (attributesChanged == false) {
                subProductResponse.message = "Subproduct already exists in the database with the same attributes";
                subProductResponse.YourSubproductID = subproduct.getSubProductId();
            }
        }
            return subProductResponse;

    }
}
