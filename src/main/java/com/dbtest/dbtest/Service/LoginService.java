package com.dbtest.dbtest.Service;

import com.dbtest.dbtest.Entity.login;
import com.dbtest.dbtest.Repository.LoginRepo;
import com.dbtest.dbtest.Schema.LoginReq;
import com.dbtest.dbtest.Schema.LoginResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepo loginrepo;

    public String loginDetails(String usernameReq, String passwordReq) {
//        LoginResponse loginResponse = new LoginResponse();
//
//        String usernameReq = loginReq.username;
//        String passwordReq = loginReq.password;
//        loginResponse.message = "Login Successful";

        login loginDB = loginrepo.findByUsername(usernameReq);
        if (loginDB == null) {
            return "InvalidUsername";
        } else {
            if (loginDB.getPassword().equals(passwordReq)) {
//                loginResponse.message = "Login Successful";
                return "LoginSuccessfull";
            } else {
//                loginResponse.message = "Login failed, invalid password";
                return "InvalidPassword";
            }

        }


    }
}
