package com.dbtest.dbtest.Service;

import com.dbtest.dbtest.Entity.ProductEntity;
import com.dbtest.dbtest.Repository.ProductRepo;
import com.dbtest.dbtest.Schema.ProductReq;
import com.dbtest.dbtest.Schema.ProductResponse;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
public class ProductService {
    public String CreatedBy = "Isha";
    public String UpdatedBy = "Isha";

    @Autowired
    public ProductRepo productRepo;



   public ProductResponse addorUpdate(ProductReq productReq)
    {
      if(productReq.productId==null) {
        return  addProduct(productReq.productName);
      }
      else{
          return updateproductname(productReq.productId, productReq.productName);
      }


    }


    ProductResponse productResponse = new ProductResponse();


    //Applying condition to check if the product name is unique or not

    public ProductResponse addProduct(String productName) {
        ProductEntity productEntity = new ProductEntity();
        //ProductReq productReq = new ProductReq();

        ProductEntity existingProduct = productRepo.findByproductName(productName);

        if(existingProduct == null) {
            adddetails(productName);
            productResponse.message = "added";

            return productResponse;
        } else {

            productResponse.message = "product name already exits";
            return productResponse;
        }

    }

    // ProductReq productReq = new ProductReq();
    public ProductResponse updateproductname(Integer productId, String productName) {
        ProductEntity productEntity = new ProductEntity();
        ProductReq productReq = new ProductReq();
        ProductEntity existingProduct = productRepo.findByproductId(productId);
        ProductEntity alreadyPresent = productRepo.findByproductName(productName);
         if (alreadyPresent != null) {
             productResponse.message = "Product name is already there in the database";
             return productResponse;
         }
         else
         {

             if(existingProduct == null) {

             //  adddetails(productname);
             productResponse.message = "product id does not exists";
             return productResponse;


            } else {

                existingProduct.setProductName(productName);
                existingProduct.setLastupdatedby(UpdatedBy);
                existingProduct.setLastupdatedbytimestamp(LocalDateTime.now());

                // String lastUpdatedBy;
                productRepo.save(existingProduct);
                productResponse.message = "Products are updated ";

                return productResponse;


            }
            //  productResponse.message = "Give new Product name";
            // return productResponse;
        }
        //  return productResponse;
    }


private ProductResponse adddetails( String productName)
{
    ProductEntity productEntity = new ProductEntity();
    ProductReq productReq = new ProductReq();


    productEntity.setProductName(productName);
    productEntity.setCreatedby(CreatedBy);
    productEntity.setLastupdatedby(UpdatedBy);
    productEntity.setLastupdatedbytimestamp(LocalDateTime.now());
    productEntity.setCreatedbytimestamp(LocalDateTime.now());


       productRepo.save(productEntity);
       productResponse.message = "Products are added ";
       productResponse.productId=productEntity.getProductId();
       return productResponse;
   }

}
