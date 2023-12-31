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

    /**
     * This is the method which is returned from the Inventory Controller by post mapping (To add details ).
     * @param productTypeReq
     * @param stockLocationReq
     * @param productNameReq
     * @param subProductNameReq
     * @param quantityReq
     * @param vendorNameReq
     * @return Json Response as the message and the Inventory id in which the entry is made.
     */
    public InventoryResponse addIntoInventory(String productTypeReq, String stockLocationReq, String productNameReq, String subProductNameReq, int quantityReq, String vendorNameReq) {

        InventoryResponse inventoryResponse = new InventoryResponse();

        ProductEntity productEntity = productRepo.findByproductName(productNameReq);
        Subproduct subproduct = subProductRepo.findBysubProductName(subProductNameReq);
        VendorEntity vendorEntity = vendorRepo.findByvendorName(vendorNameReq);
        checkValidation(productEntity, subproduct, vendorEntity);

        Inventory inventory = inventoryRepo.findByProductDetailsAndSubProductDetailsAndVendorDetails(productEntity, subproduct, vendorEntity);

        if (!Objects.nonNull(inventory)) {

            return addDetails(productTypeReq, stockLocationReq, productNameReq, subProductNameReq, quantityReq, vendorNameReq);

        }
        return inventoryResponse;
    }

    /**
     * This method is used to throw exceptions if a product , sub-product or vendor is not valid (not present in particular table).
     *
     * @param productEntity
     * @param subproduct
     * @param vendorEntity
     */
    private void checkValidation(ProductEntity productEntity, Subproduct subproduct, VendorEntity vendorEntity) {
        if (!Objects.nonNull(productEntity)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request - Product Name not Valid ");
        }
        if (!Objects.nonNull(subproduct)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request - Sub-Product Name not Valid ");
        }
        if (!Objects.nonNull(vendorEntity)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request - Vendor Name not Valid ");
        }
    }

    /**
     * This method is for updating the existing details in the Inventory , when the Required inventoryId is matched .
     *
     * @param productTypeReq
     * @param stockLocationReq
     * @param productNameReq
     * @param subProductNameReq
     * @param quantityReq
     * @param idReq
     * @param vendorNameReq
     * @return Json Response as the message and the Inventory id in which the update is made.
     * @author Arijeet Sengupta
     */
    public InventoryResponse updateIntoInventory(String productTypeReq, String stockLocationReq, String productNameReq, String subProductNameReq, int quantityReq, int idReq, String vendorNameReq) {
        InventoryResponse inventoryResponse = new InventoryResponse();

        ProductEntity productEntity = productRepo.findByproductName(productNameReq);
        Subproduct subproduct = subProductRepo.findBysubProductName(subProductNameReq);
        VendorEntity vendorEntity = vendorRepo.findByvendorName(vendorNameReq);
        checkValidation(productEntity, subproduct, vendorEntity);

        Inventory inventory = inventoryRepo.findByinventoryid(idReq);
        if (Objects.nonNull(inventory)) {
            if (Objects.equals(inventory.getQuantity(), quantityReq) && Objects.equals(inventory.getStocklocation(), stockLocationReq) && Objects.equals(inventory.getProductType(), productTypeReq) && Objects.equals(inventory.getProductDetails(), productNameReq) && Objects.equals(inventory.getVendorDetails(), vendorNameReq) && Objects.equals(inventory.getSubProductDetails(), subProductNameReq)) {
                inventoryResponse.message = "No Update made to the DB since the request data already exists in the DB";
            } else {
                inventory.setStocklocation(stockLocationReq);
                inventory.setQuantity(quantityReq);
                inventory.setProductType(productTypeReq);
                Double purchasePrice = quantityReq * subproduct.getProductPurchasePrice();
                Double sellingPrice = quantityReq * subproduct.getProductSellingPrice();
                inventory.setProductPurchasePrice(purchasePrice);
                inventory.setProductSellingPrice(sellingPrice);
                inventory.setLastUpdatedTimestamp(LocalDateTime.now());
                inventory.setLastUpdatedBy(LAST_UPDATED_BY);
                inventory.setProductDetails(productEntity);
                inventory.setSubProductDetails(subproduct);
                inventory.setVendorDetails(vendorEntity);
                inventoryRepo.save(inventory);
                inventoryResponse.message = "The record updated successfully";
                inventoryResponse.inventoryId = inventory.getInventoryid();
            }


        } else {
            inventoryResponse.message = "Id not found ";
        }
        return inventoryResponse;

    }

    /**
     * This method is for adding the details in the Inventory , while the conditions are successfully checked.
     *
     * @param productTypeReq
     * @param stockLocationReq
     * @param productNameReq
     * @param subProductNameReq
     * @param quantityReq
     * @param vendorNameReq
     * @return Json Response as the message and the Inventory id in which the entry is made.
     * @author Arijeet Sengupta
     */

    private InventoryResponse addDetails(String productTypeReq, String stockLocationReq, String productNameReq, String
            subProductNameReq, int quantityReq, String vendorNameReq) {
        Inventory inventory = new Inventory();

        InventoryResponse inventoryResponse = new InventoryResponse();

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
        inventory.setLastUpdatedBy(LAST_UPDATED_BY);
        inventory.setLastUpdatedTimestamp(LocalDateTime.now());
        inventory.setCreatedByTimestamp(LocalDateTime.now());
        inventory.setCreatedBy(CREATED_BY);

        inventoryRepo.save(inventory);

        inventoryResponse.message = "added to inventory";
        inventoryResponse.inventoryId = inventory.getInventoryid();

        return inventoryResponse;
    }
}

