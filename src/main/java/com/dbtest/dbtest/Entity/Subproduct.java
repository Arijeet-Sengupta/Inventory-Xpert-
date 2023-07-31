package com.dbtest.dbtest.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name= "subproductdetails")
public class Subproduct {
    @Id
    @Column(name="subproductid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subProductId;

    @Column(name="subproductname")
    private String subProductName;

    @OneToOne
    @JoinColumn(name = "productid", referencedColumnName = "productid")
    private ProductEntity productDetails;

    @OneToOne
    @JoinColumn(name = "vendorid", referencedColumnName = "vendorid")
    private VendorEntity vendorDetails;

    @Column(name="productsellingprice")
    private float productSellingPrice;

    @Column(name="productpurchaseprice")
    private float productPurchasePrice;

    @Column(name="lastupdatedby")
    private String lastUpdatedBy;

    @Column(name="lastupdatedtimestamp")
    private LocalDateTime lastUpdatedTimestamp;

    @Column(name="createdby")
    private String createdBy;

    @Column(name="createdbytimestamp")
    private LocalDateTime createdByTimestamp;

}
