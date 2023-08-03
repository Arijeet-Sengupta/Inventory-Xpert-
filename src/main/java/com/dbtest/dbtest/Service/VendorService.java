package com.dbtest.dbtest.Service;

import com.dbtest.dbtest.Entity.VendorEntity;
import com.dbtest.dbtest.Repository.VendorRepo;
import com.dbtest.dbtest.Schema.VendorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class VendorService {


    public static final String CREATED_BY = "nayan";
    public static final String LAST_UPDATED_BY = "nayan";
    @Autowired
    public VendorRepo vendorRepo;
    VendorResponse vendorResponse = new VendorResponse();


    public VendorResponse addVendor(String vendorname, String vendorlocation, String email) {

        VendorEntity ve = vendorRepo.findByVendorNameAndVendorLocationAndEmail(vendorname, vendorlocation, email);
        if (!Objects.nonNull(ve)) {

            return addintovendor(vendorname, vendorlocation, email);



        } else {
            vendorResponse.message = "VendorDetaild Already exists";
            vendorResponse.vendorid = ve.getVendorid();
        }
        return vendorResponse;
    }

    private VendorResponse addintovendor(String vendorname, String vendorlocation, String email) {
        VendorEntity ve = new VendorEntity();
        ve.setVendorName(vendorname);
        ve.setVendorLocation(vendorlocation);
        ve.setEmail(email);

        ve.setLastUpdatedByTimestamp(LocalDateTime.now());
        ve.setLastUpdatedBy(LAST_UPDATED_BY);

        ve.setCreatedByTimestamp(LocalDateTime.now());
        ve.setCreatedBy(CREATED_BY);
        vendorRepo.save(ve);
        vendorResponse.vendorid = ve.getVendorid();
        vendorResponse.message = "Vendor Details addded Succesfully";
        return vendorResponse;

    }

    public VendorResponse UpdatedVendorDetails(int vendorid, String vendorName, String vendorLocation, String email) {


        VendorEntity existingVendor = vendorRepo.findByVendorid(vendorid);

        if (existingVendor == null) {
            vendorResponse.message = "Id does not exists";
        } else {
            boolean check = false;
            if (!existingVendor.getVendorName().equals(vendorName)) {
                existingVendor.setVendorName(vendorName);

                check = true;
            }
            if (!existingVendor.getEmail().equals(email)) {
                existingVendor.setEmail(email);

                check = true;
            }
            if (!existingVendor.getVendorLocation().equals(vendorLocation)) {
                existingVendor.setVendorLocation(vendorLocation);

                check = true;
            }
            if (check == true) {
                existingVendor.setLastUpdatedByTimestamp(LocalDateTime.now());
                existingVendor.setCreatedByTimestamp(LocalDateTime.now());
                existingVendor.setCreatedBy(CREATED_BY);
                existingVendor.setLastUpdatedBy(LAST_UPDATED_BY);
                vendorRepo.save(existingVendor);
                vendorResponse.vendorid = existingVendor.getVendorid();
                vendorResponse.message = "Vendor Details Updated Succesfully";
            } else if (check == false) {
                vendorResponse.message = "Vendor Details already exist";
                vendorResponse.vendorid = existingVendor.getVendorid();
            }
        }
        return vendorResponse;
    }

}
