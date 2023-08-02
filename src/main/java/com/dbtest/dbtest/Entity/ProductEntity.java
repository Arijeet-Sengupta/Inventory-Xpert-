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










}
