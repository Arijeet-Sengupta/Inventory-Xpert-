package com.dbtest.dbtest.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;



public class LoginReq {
    @JsonProperty
   public String username;
    @JsonProperty
    public String password;
}
