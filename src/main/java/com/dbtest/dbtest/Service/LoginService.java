package com.dbtest.dbtest.Service;

import com.dbtest.dbtest.Entity.Account;
import com.dbtest.dbtest.Entity.User;
import com.dbtest.dbtest.Repository.LoginRepo;
import com.dbtest.dbtest.Repository.SignupRepo;
import com.dbtest.dbtest.Schema.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoginService {

    @Autowired
    private LoginRepo loginrepo;
    @Autowired
    private SignupRepo signupRepo;

    LoginResponse loginResponse = new LoginResponse();

    public LoginResponse loginDetails(String emailReq, String passwordReq) {


        Account account = loginrepo.findByEmail(emailReq);
        if (account == null) {
            loginResponse.message = "InvalidUsername";
            //  return "InvalidUsername";
        } else {
            if (account.getPassword().equals(passwordReq)) {
                loginResponse.message = "Login Successful";
                LocalDateTime last_loginReq = LocalDateTime.now();
                updateLoginDate(emailReq, last_loginReq);
                // return "LoginSuccessfull";
            } else {
                loginResponse.message = "Login failed, invalid password";
//                return "InvalidPassword";
            }
        }
//        }
        return loginResponse;
//
    }

    private void updateLoginDate(String emailReq, LocalDateTime last_loginReq) {

        loginrepo.updateLastLogin(last_loginReq, emailReq);
    }

    public LoginResponse signupDetails(String emailReq, String fullNameReq, double phoneNumberReq, String companyNameReq, String designationReq, String addressReq, String passwordReq) {
        LoginResponse loginResponse = new LoginResponse();

        User user = signupRepo.findByemailId(emailReq);
        if (user == null) {
            adduser(emailReq, fullNameReq, phoneNumberReq, companyNameReq, designationReq, addressReq, passwordReq);
            loginResponse.message = "Signup Successful";
            addaccount(emailReq, passwordReq);
        } else {
            loginResponse.message = "Email Already exits";
        }
        return loginResponse;
    }

    private LoginResponse adduser(String emailReq, String fullNameReq, double phoneNumberReq, String companyNameReq, String designationReq, String addressReq, String passwordReq) {
        User user = new User();
        user.setEmailId(emailReq);
        user.setFullName(fullNameReq);
        user.setPhoneNumber(phoneNumberReq);
        user.setCompanyName(companyNameReq);
        user.setDesignation(designationReq);
        user.setAddress(addressReq);
        user.setPassword(passwordReq);
        user.setSignupDate(LocalDateTime.now());

        signupRepo.save(user);
//        return "SignupSuccessful";

        loginResponse.message = "Signup successful";

        return loginResponse;
    }

    public void addaccount(String email, String password) {
        User user = signupRepo.findByemailId(email);
        Account account = new Account();
        account.setEmail(email);
        account.setPassword(password);
        account.setUser(user);

        loginrepo.save(account);

    }

}

