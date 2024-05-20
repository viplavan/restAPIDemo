package com.restapi.restdemo.controller;

import com.restapi.restdemo.model.CloudVendorModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIService {


    CloudVendorModel cloudVendorModel;

    @GetMapping("{vendorId}")
    public CloudVendorModel getCloudVendorDetails(String vendorId){

        return cloudVendorModel;
                //("C1", "Nama", "Address One","XXXX");
    }
    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendorModel cloudVendorModel){

        this.cloudVendorModel = cloudVendorModel;
        return "Cloud Vendor Created successfully";

    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendorModel cloudVendorModel){
        this.cloudVendorModel = cloudVendorModel;
        return "Cloud Vendor Updated successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(String vendorId){
        this.cloudVendorModel = null;
        return "Cloud Vendor Deleted successfully";
    }


}
