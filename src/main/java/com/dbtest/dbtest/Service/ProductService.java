package com.dbtest.dbtest.Service;

import com.dbtest.dbtest.Entity.ProductEntity;
import com.dbtest.dbtest.Repository.ProductRepo;
import com.dbtest.dbtest.Schema.ProductResponse;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
public class ProductService {
    public String CreatedBy="Isha";
    public String UpdatedBy="Isha";

   @Autowired
   public ProductRepo productRepo;

   ProductResponse productResponse = new ProductResponse();


   //Applying condition to check if the product name is unique or not
   public ProductResponse addProduct( String productname)
   {
      ProductEntity productEntity = new ProductEntity();

       ProductEntity existingProduct = productRepo.findByproductname(productname);
      if(existingProduct==null)
       {
         adddetails(productname);
          productResponse.message="added";
          return productResponse;
       }
       else
       {
           productResponse.message="product name already exits";
           return productResponse;
       }

   }



//  public ProductResponse updateProduct(String productname){
//       ProductEntity productEntity = new ProductEntity();
//       String productNameReq = productname;
//     ProductEntity existingProduct = productRepo.findByproductid(Integer.parseInt("productid"));
//       if (existingProduct != null) {
//
//          existingProduct.setproductname(productNameReq);
//          existingProduct.setlastupdatedby(UpdatedBy);
//           existingProduct.setlastupdatedbytimestamp(LocalDateTime.now());
//          productRepo.updateproductname(productNameReq, String.valueOf(existingProduct));
//       }
//       else {
////          // productEntity.setcreatedbytimestamp(LocalDateTime.now());
////           //productRepo.save(productEntity);
//          productResponse.message = "Products are updated ";
//           return productResponse;
//       }
//       productResponse.message = "Products are updated ";
//     return productResponse;
// }
//

private ProductResponse adddetails( String productname)
{
    ProductEntity productEntity = new ProductEntity();
    productEntity.setproductname(productname);
    productEntity.setcreatedby(CreatedBy);
    productEntity.setlastupdatedby(UpdatedBy);
    productEntity.setlastupdatedbytimestamp(LocalDateTime.now());
    productEntity.setcreatedbytimestamp(LocalDateTime.now());

       productRepo.save(productEntity);
       productResponse.message = "Products are added ";
       return productResponse;
   }

}
