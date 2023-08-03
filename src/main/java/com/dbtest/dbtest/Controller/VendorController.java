package com.dbtest.dbtest.Controller;

import com.dbtest.dbtest.Schema.VendorResponse;
import com.dbtest.dbtest.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class VendorController {
    @Autowired
    public VendorService vendorService;

    @PostMapping("/vendor")
    public VendorResponse AddVendorDetails(

        @Validated @RequestParam ("vendorname") String vendorname,
          @Validated  @RequestParam("vendorlocation") String vendorlocation,
         @Validated   @RequestParam("email") String email)
    // @RequestParam("lastupdatedby") String lastupdatedby,
    // @RequestParam("createdby") String createdby)
    {
        return vendorService.addVendor(vendorname, vendorlocation, email);
    }

    @PutMapping("/vendor")
    public VendorResponse UpdateVendorDetails(
       @Validated     @RequestParam("vendorid") int vendorid,
      @Validated    @RequestParam("vendorname") String vendorname,
           @Validated @RequestParam("vendorlocation") String vendorlocation,
           @Validated @RequestParam("email") String email)

    {
        return vendorService.UpdatedVendorDetails(vendorid,vendorname, vendorlocation, email);
    }










}