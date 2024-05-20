package com.restserviceapi.restaipdemo.service.impl;

import com.restserviceapi.restaipdemo.exception.CloudVendorNotFoundException;
import com.restserviceapi.restaipdemo.model.CloudVendorModel;
import com.restserviceapi.restaipdemo.repository.CloudVendorRepository;
import com.restserviceapi.restaipdemo.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendorModel cloudVendorModel) {
        //More Business Logic
        cloudVendorRepository.save(cloudVendorModel);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendorModel cloudVendorModel) {
        //More Business Logic
        cloudVendorRepository.save(cloudVendorModel);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        //More Business Logic
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Success";
    }

    @Override
    public CloudVendorModel getCloudVendor(String cloudVendorId) {
                //More Business Logic
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendorModel> getByVendorName(String cloudVendorName) {
       //More Business Logic
        return cloudVendorRepository.findByVendorName(cloudVendorName);
    }

    @Override
    public List<CloudVendorModel> getAllCloudVendors() {
        //More Business Logic
        return cloudVendorRepository.findAll();
    }
}
