package com.dbtest.dbtest.Controller;

import com.dbtest.dbtest.Schema.LoginResponse;
import com.dbtest.dbtest.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "Login";
    }

    @Autowired
    private LoginService loginService;


    @PostMapping("/login")
    public LoginResponse postDetails(@RequestParam("email") String email,
                                     @RequestParam("password") String password) {
        return loginService.loginDetails(email, password);
    }

    @GetMapping("/Signup")
    public String signup() {
        return "Signup";
    }

    @PostMapping("/Signup")
    public LoginResponse signupDetails(@RequestParam("emailId") String emailId,
                                       @RequestParam("fullName") String fullName,
                                       @RequestParam("phoneNumber") double phoneNumber,
                                       @RequestParam("companyName") String companyName,
                                       @RequestParam("designation") String designation,
                                       @RequestParam("address") String address,
                                       @RequestParam("password") String password) {
        return loginService.signupDetails(emailId, fullName, phoneNumber, companyName, designation, address, password);
    }
}
