package com.dbtest.dbtest.Controller;

import com.dbtest.dbtest.Schema.VendorResponse;
import com.dbtest.dbtest.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorController {
    @Autowired
    public VendorService vendorService;

    @PostMapping("/vendor")
    public String AddVendorDetails(
            @RequestParam("vendorname") String vendorname,
            @RequestParam("vendorlocation") String vendorlocation,
            @RequestParam("email") String email)
           // @RequestParam("lastupdatedby") String lastupdatedby,
           // @RequestParam("createdby") String createdby)
    {
        return vendorService.addVendor(vendorname, vendorlocation, email);


    }

}