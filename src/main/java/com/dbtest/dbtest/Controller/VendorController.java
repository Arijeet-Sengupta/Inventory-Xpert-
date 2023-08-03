package com.dbtest.dbtest.Controller;

import com.dbtest.dbtest.Schema.VendorResponse;
import com.dbtest.dbtest.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/updateVendor")
    public VendorResponse UpdateVendorDetails(
            @RequestParam("vendorid") int vendorid,
            @RequestParam("vendorname") String vendorname,
            @RequestParam("vendorlocation") String vendorlocation,
            @RequestParam("email") String email)

    {
        return vendorService.UpdatedVendorDetails(vendorid,vendorname, vendorlocation, email);
    }










}