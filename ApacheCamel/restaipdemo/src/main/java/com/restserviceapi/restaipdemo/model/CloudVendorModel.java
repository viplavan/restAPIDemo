package com.restserviceapi.restaipdemo.model;

import jakarta.persistence.*;

@Entity
@Table(name= "cloud_vendor_info")
public class CloudVendorModel {

    @Id
    private String vendorId;
    @Column(name= "vendor_name")
    private String vendorName;
    @Column(name= "vendor_address")
    private String vendorAddress;
    @Column(name= "vendor_phone_number")
    private String vendorPhoneNumber;

    public CloudVendorModel(){}

    public CloudVendorModel(String vendorId, String vendorName, String vendorAddress, String vendorPhoneNumber) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.vendorAddress = vendorAddress;
        this.vendorPhoneNumber = vendorPhoneNumber;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }

    public String getVendorPhoneNumber() {
        return vendorPhoneNumber;
    }

    public void setVendorPhoneNumber(String vendorPhoneNumber) {
        this.vendorPhoneNumber = vendorPhoneNumber;
    }


}
