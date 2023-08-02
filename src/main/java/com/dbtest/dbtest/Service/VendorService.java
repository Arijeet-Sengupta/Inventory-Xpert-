package com.dbtest.dbtest.Service;

import com.dbtest.dbtest.Entity.VendorEntity;
import com.dbtest.dbtest.Repository.VendorRepo;
import com.dbtest.dbtest.Schema.VendorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VendorService {


    public static final String CREATED_BY = "nayan";
    public static final String LAST_UPDATED_BY = "nayan";
    @Autowired
    public VendorRepo vendorRepo;
    VendorResponse vendorResponse = new VendorResponse();


    public String addVendor(String vendorname, String vendorlocation, String email
    ) {
        VendorEntity existingVendor = vendorRepo.findByVendorName(vendorname);

        if (existingVendor == null) {


            addintoVendor(vendorname, vendorlocation, email);

            vendorResponse.message = "Added";
        } else {
            if (existingVendor.getEmail().equals(email)) {
                if (!(existingVendor.getVendorLocation().equals(vendorlocation))) {

                    existingVendor.setVendorLocation(vendorlocation);
                    existingVendor.setLastUpdatedBy(LAST_UPDATED_BY);
                    existingVendor.setLastUpdatedByTimestamp(LocalDateTime.now());

                } else {
                    vendorResponse.message = "Data Already Exist";
                }
            } else {
                existingVendor.setEmail(email);
                existingVendor.setLastUpdatedBy(LAST_UPDATED_BY);
                existingVendor.setLastUpdatedByTimestamp(LocalDateTime.now());

            }
            vendorRepo.save(existingVendor);


        }
        return vendorResponse.message= " ";
    }

        private void addintoVendor (String vendorname, String vendorlocation, String email){
            VendorEntity ve = new VendorEntity();
            ve.setVendorName(vendorname);
            ve.setVendorLocation(vendorlocation);
            ve.setEmail(email);

            ve.setLastUpdatedByTimestamp(LocalDateTime.now());

            ve.setCreatedByTimestamp(LocalDateTime.now());
            ve.setCreatedBy(CREATED_BY);
            vendorRepo.save(ve);
        }

}
