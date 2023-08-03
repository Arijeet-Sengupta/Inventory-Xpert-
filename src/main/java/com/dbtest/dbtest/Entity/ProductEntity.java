package com.dbtest.dbtest.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="productdetails")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="productid")
    private int productId;

    @Column(name="productname")
    private String productName;

    @Column(name="lastupdatedby")
    private String lastupdatedby;

    @Column(name="lastupdatedbytimestamp")
    private LocalDateTime lastupdatedbytimestamp;

    @Column(name="createdby")
    private String createdby;

    @Column(name="createdbytimestamp")
    private LocalDateTime createdbytimestamp;



    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getLastupdatedby() {
        return lastupdatedby;
    }

    public void setLastupdatedby(String lastupdatedby) {
        this.lastupdatedby = lastupdatedby;
    }

    public LocalDateTime getLastupdatedbytimestamp() {
        return lastupdatedbytimestamp;
    }

    public void setLastupdatedbytimestamp(LocalDateTime lastupdatedbytimestamp) {
        this.lastupdatedbytimestamp = lastupdatedbytimestamp;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public LocalDateTime getCreatedbytimestamp() {
        return createdbytimestamp;
    }

    public void setCreatedbytimestamp(LocalDateTime createdbytimestamp) {
        this.createdbytimestamp = createdbytimestamp;
    }
}
