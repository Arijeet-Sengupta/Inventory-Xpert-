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
    private int productid;

    @Column(name="productname")
    private String productname;

    @Column(name="lastupdatedby")
    private String lastupdatedby;

    @Column(name="lastupdatedbytimestamp")
    private LocalDateTime lastupdatedbytimestamp;

    @Column(name="createdby")
    private String createdby;

    @Column(name="createdbytimestamp")
    private LocalDateTime createdbytimestamp;

    public int getproductid() {
        return productid;
    }

    public void setproductid(int productid) {
        this.productid = productid;
    }

    public String getproductname() {
        return productname;
    }

    public void setproductname(String productname) {
        this.productname = productname;
    }

    public String getlastupdatedby() {
        return lastupdatedby;
    }

    public void setlastupdatedby(String lastupdatedby) {
        this.lastupdatedby = lastupdatedby;
    }

    public LocalDateTime getlastupdatedbytimestamp() {
        return lastupdatedbytimestamp;
    }

    public void setlastupdatedbytimestamp(LocalDateTime lastupdatedbytimestamp) {
        this.lastupdatedbytimestamp = lastupdatedbytimestamp;
    }

    public String getcreatedby() {
        return createdby;
    }

    public void setcreatedby(String createdby) {
        this.createdby = createdby;
    }

    public LocalDateTime getcreatedbytimestamp() {
        return createdbytimestamp;
    }

    public void setcreatedbytimestamp(LocalDateTime createdbytimestamp) {
        this.createdbytimestamp = createdbytimestamp;
    }




}
