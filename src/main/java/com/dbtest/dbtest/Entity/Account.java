package com.dbtest.dbtest.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Account")
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    @Column(name = "Email")
    private String email;


    @Column(name = "Password")
    private String password;

    @OneToOne
    @JoinColumn(name = "User_id", referencedColumnName = "User_Id")
    private User user;

    @Column(name = "last_login")
    private LocalDateTime last_login;
}

