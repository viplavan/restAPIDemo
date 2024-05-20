package com.restserviceapi.restaipdemo.controller;

import com.restserviceapi.restaipdemo.model.CloudVendorModel;
import com.restserviceapi.restaipdemo.repository.CloudVendorRepository;
import com.restserviceapi.restaipdemo.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
//import static org.springframework.http.ResponseEntity.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CloudVendorController.class)
class CloudVendorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CloudVendorService cloudVendorService;
    CloudVendorModel cloudVendorModelOne;
    CloudVendorModel cloudVendorModelTwo;
    List<CloudVendorModel> cloudVendorModelList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cloudVendorModelOne = new CloudVendorModel("1","Amazon","USA","XXXXXX");
        cloudVendorModelTwo = new CloudVendorModel("2","GCP","UK","YYYYYY");
        cloudVendorModelList.add(cloudVendorModelOne);
        cloudVendorModelList.add(cloudVendorModelTwo);
    }

    @AfterEach
    void tearDown() {

    }


    @Test
    void testGetCloudVendorDetails() throws Exception {

        when(cloudVendorService.getCloudVendor("1"))
                .thenReturn(cloudVendorModelOne);
        this.mockMvc.perform(get("/cloudvendor/1"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getAllCloudVendorDetails() {
    }

    @Test
    void updateCloudVendorDetails() {
    }

    @Test
    void deleteCloudVendorDetails() {
    }

}