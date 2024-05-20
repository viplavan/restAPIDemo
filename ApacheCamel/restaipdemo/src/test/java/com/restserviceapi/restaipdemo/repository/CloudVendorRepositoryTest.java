package com.restserviceapi.restaipdemo.repository;

import com.restserviceapi.restaipdemo.model.CloudVendorModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CloudVendorRepositoryTest {

    @Autowired
    CloudVendorRepository cloudVendorRepository;
    CloudVendorModel cloudVendorModel;

    @BeforeEach
    void setUp() {
        cloudVendorModel = new CloudVendorModel("1", "Amazon",
                "USA", "XXXXXX");
        cloudVendorRepository.save(cloudVendorModel);
    }

    @AfterEach
    void tearDown() {
     cloudVendorModel = null;
     cloudVendorRepository.deleteAll();
    }

    //Testcase SUCCESS
    @Test
    void testFindByVendorName_Found(){
     List<CloudVendorModel> cloudVendorModelList= cloudVendorRepository.findByVendorName("Amazon");
     assertThat(cloudVendorModelList.get(0).getVendorId()).isEqualTo(cloudVendorModel.getVendorId());
     assertThat(cloudVendorModelList.get(0).getVendorAddress()).isEqualTo(cloudVendorModel.getVendorAddress());
    }

    //Testcase FAILURE
  /*  @Test
    void testFindByVendorName_NotFound(){
        List<CloudVendorModel> cloudVendorModelList= cloudVendorRepository.findByVendorName("GCP");
        *//*assertThat(cloudVendorModelList.get(0).getVendorId()).isEqualTo(cloudVendorModel.getVendorId());
        assertThat(cloudVendorModelList.get(0).getVendorAddress()).isEqualTo(cloudVendorModel.getVendorAddress());*//*
        assertThat(cloudVendorModelList.isEmpty()).isFalse();
    }*/

    @Test
    void testFindByVendorName_NotFound_True(){
        List<CloudVendorModel> cloudVendorModelList= cloudVendorRepository.findByVendorName("GCP");
        /*assertThat(cloudVendorModelList.get(0).getVendorId()).isEqualTo(cloudVendorModel.getVendorId());
        assertThat(cloudVendorModelList.get(0).getVendorAddress()).isEqualTo(cloudVendorModel.getVendorAddress());*/
        assertThat(cloudVendorModelList.isEmpty()).isTrue();
    }

}
