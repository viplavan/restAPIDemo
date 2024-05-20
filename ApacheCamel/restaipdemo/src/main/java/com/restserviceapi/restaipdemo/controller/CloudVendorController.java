package com.restserviceapi.restaipdemo.controller;

import com.restserviceapi.restaipdemo.model.CloudVendorModel;
import com.restserviceapi.restaipdemo.response.ResponseHandler;
import com.restserviceapi.restaipdemo.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {


    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    //Read specific Cloud Vendor Details
    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
       return ResponseHandler.responseBuilder("Requested Vendor details ate given here",
                HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));
                //("C1", "Nama", "Address One","XXXX");
    }

    //Read All Cloud Vendor Details
    @GetMapping
    public List<CloudVendorModel> getAllCloudVendorDetails(){

        return cloudVendorService.getAllCloudVendors();
        //("C1", "Nama", "Address One","XXXX");
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendorModel cloudVendorModel){

        cloudVendorService.createCloudVendor(cloudVendorModel);
        return "Cloud Vendor Created successfully";

    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendorModel cloudVendorModel){
        cloudVendorService.updateCloudVendor(cloudVendorModel);
        return "Cloud Vendor Updated successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor Deleted successfully";
    }


}
