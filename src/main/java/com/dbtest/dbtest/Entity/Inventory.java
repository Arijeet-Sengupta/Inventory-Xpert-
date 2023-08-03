package com.dbtest.dbtest.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inventory")
public class Inventory {

    @Id
    @Column(name = "inventoryid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inventoryid;

    @OneToOne
    @JoinColumn(name = "productid", referencedColumnName = "productid")
    private ProductEntity productDetails;

//    @Column(name = "productid")
//    private int productId;

    @OneToOne
    @JoinColumn(name = "subproductid", referencedColumnName = "subproductid")
    private Subproduct subProductDetails;

    @OneToOne
    @JoinColumn(name = "vendorid", referencedColumnName = "vendorid")
    private VendorEntity vendorDetails;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "producttype")
    private String productType;

    @Column(name = "stocklocation")
    private String stocklocation;

    @Column(name="productpurchaseprice")
    private Double productPurchasePrice;

    @Column(name="productsellingprice")
    private Double productSellingPrice;

    @Column(name = "lastupdatedby")
    private String lastUpdatedBy;

    @Column(name = "lastupdatedtimestamp")
    private LocalDateTime lastUpdatedTimestamp;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "createdbytimestamp")
    private LocalDateTime createdByTimestamp;
}
