package com.restserviceapi.restaipdemo.service;

import com.restserviceapi.restaipdemo.model.CloudVendorModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CloudVendorService {

    public String createCloudVendor(CloudVendorModel cloudVendorModel);
    public String updateCloudVendor(CloudVendorModel cloudVendorModel);
    public String deleteCloudVendor(String cloudVendorId);

    public CloudVendorModel getCloudVendor(String cloudVendorId);
    public List<CloudVendorModel> getByVendorName(String vendorName);

    public List<CloudVendorModel> getAllCloudVendors();
}
