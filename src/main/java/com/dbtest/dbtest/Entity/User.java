package com.dbtest.dbtest.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "User")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int User_id;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private double phoneNumber;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "designation")
    private String designation;

    @Column(name = "Address")
    private String address;

    @Column(name = "signup_date")
    private LocalDateTime signupDate;

    @Column(name = "password")
    private String password;

}
