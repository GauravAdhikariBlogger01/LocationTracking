package com.turvo.locationtracking;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.turvo.locationtracking.controller.LocationTrackingController;
import com.turvo.locationtracking.service.DriverVehicleRegistrationService;
import com.turvo.locationtracking.service.TrackingDetailService;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class AppconfigTest {

	
	@InjectMocks
	private LocationTrackingController locationTrackingController; 
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
}
