package com.restserviceapi.restaipdemo.service.impl;

import com.restserviceapi.restaipdemo.model.CloudVendorModel;
import com.restserviceapi.restaipdemo.repository.CloudVendorRepository;
import com.restserviceapi.restaipdemo.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CloudVendorServiceImplTest {

    @Mock
    private CloudVendorRepository cloudVendorRepository;
    private CloudVendorService cloudVendorService;
    AutoCloseable autoCloseable;
    CloudVendorModel cloudVendorModel;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
        cloudVendorModel = new CloudVendorModel("1","Amazon","USA","XXXXXX");
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void createCloudVendor() {
        mock(CloudVendorModel.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.save(cloudVendorModel)).thenReturn(cloudVendorModel);
        assertThat(cloudVendorService.createCloudVendor(cloudVendorModel)).isEqualTo("Success");

    }

    @Test
    void testUpdateCloudVendor() {

        mock(CloudVendorModel.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.save(cloudVendorModel)).thenReturn(cloudVendorModel);
        assertThat(cloudVendorService.updateCloudVendor(cloudVendorModel)).isEqualTo("Success");

    }

    @Test
    void testGetCloudVendor() {

        mock(CloudVendorModel.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findById("1")).thenReturn(Optional.ofNullable(cloudVendorModel));
        assertThat(cloudVendorService.getCloudVendor("1").getVendorName())
                .isEqualTo(cloudVendorModel.getVendorName());

    }

    @Test
    void testGetByVendorName() {

        mock(CloudVendorModel.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findByVendorName("Amazon"))
                .thenReturn(new ArrayList<CloudVendorModel>(Collections.singleton(cloudVendorModel)));
        assertThat(cloudVendorService.getByVendorName("Amazon").get(0).getVendorId())
                .isEqualTo(cloudVendorModel.getVendorId());
    }

    @Test
    void testGetAllCloudVendors() {

        mock(CloudVendorModel.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findAll()).thenReturn(
                new ArrayList<CloudVendorModel>(Collections.singleton(cloudVendorModel))
        );

        assertThat(cloudVendorService.getAllCloudVendors().get(0).getVendorPhoneNumber())
                .isEqualTo(cloudVendorModel.getVendorPhoneNumber());
    }

    @Test
    void testDeleteCloudVendor() {

        mock(CloudVendorModel.class);
        mock(CloudVendorRepository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(cloudVendorRepository)
                .deleteById(any());
        assertThat(cloudVendorService.deleteCloudVendor("1")).isEqualTo("Success");

    }

}