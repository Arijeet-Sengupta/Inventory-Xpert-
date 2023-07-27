package com.dbtest.dbtest.Controller;
import com.dbtest.dbtest.Entity.login;
import com.dbtest.dbtest.Schema.LoginReq;
import com.dbtest.dbtest.Schema.LoginResponse;
import com.dbtest.dbtest.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "Login";
    }
    @Autowired
    private LoginService loginService;


    @PostMapping("/login")
    public String postDetails(@RequestParam("username") String username,
                              @RequestParam("password") String password){
        return loginService.loginDetails(username, password);
    }
    @GetMapping("/Signup")
    public String signup(){
        return "Signup";
    }
    @PostMapping("/Signup")
    public String signupDetails(@RequestParam("username") String username,
                                @RequestParam("password") String password){
        return loginService.signupDetails(username, password);
    }

//    public LoginResponse postDetails(@RequestBody LoginReq loginReq){
////    LoginResponse loginResponse = loginService.loginDetails(loginReq);
//        return loginService.loginDetails(loginReq);
//    }
}
