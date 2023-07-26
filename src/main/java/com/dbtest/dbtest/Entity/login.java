package com.dbtest.dbtest.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "login")
@NoArgsConstructor
@AllArgsConstructor
public class login {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;

    @Column(name ="Username")
    private String username;


    @Column(name="Password")
    private String password;

}
