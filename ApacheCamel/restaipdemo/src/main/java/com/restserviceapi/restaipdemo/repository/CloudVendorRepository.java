package com.restserviceapi.restaipdemo.repository;

import com.restserviceapi.restaipdemo.model.CloudVendorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CloudVendorRepository extends JpaRepository<CloudVendorModel, String> {

    List<CloudVendorModel> findByVendorName(String vendorName);

}
