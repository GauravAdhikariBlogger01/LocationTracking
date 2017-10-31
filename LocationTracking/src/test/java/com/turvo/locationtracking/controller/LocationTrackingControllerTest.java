/*package com.turvo.locationtracking.controller;

import static org.mockito.Mockito.atLeast;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;

import com.turvo.locationtracking.domain.TrackingDetail;
import com.turvo.locationtracking.domain.User;
import com.turvo.locationtracking.repository.UserRepository;
import com.turvo.locationtracking.service.DeviceDetailService;
import com.turvo.locationtracking.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class LocationTrackingControllerTest {

	@Mock
	LocationTrackingController locationTrackingController;
	
	@Mock
	DeviceDetailService deviceDetailService;
	
	private List<TrackingDetail> trackingDetails;
	
	private TrackingDetail trackingDetail;
	
	@Before
	public void setUpBeforeClass() throws Exception {
		trackingDetails = new ArrayList<>();
		TrackingDetail trackingD = new TrackingDetail();
		trackingD.setAdditionalInfo("Test Details");
		trackingD.setLatitude(1l);
		trackingD.setLongitude(2l);
		trackingD.setSpeed(5l);
	//	trackingD.add(trackingDetail);
	//	locationTrackingController = new LocationTrackingController();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testShowWelcomePage() {
		ModelMap map = new ModelMap();
		Mockito.when(locationTrackingController.showWelcomePage(map)).thenReturn("welcome");
		String msg = locationTrackingController.showWelcomePage(map);
		org.junit.Assert.assertSame("welcome", msg);
		Mockito.verify(locationTrackingController, atLeast(1)).showWelcomePage(map);
	}

	@Test
	public void testListAllUsers() {
		
		Mockito.when(deviceDetailService.getRecordbyDeviceId(1l)).thenReturn(trackingDetail);
		users = userService.retrieveAllUsers();
		Mockito.verify(userService, atLeast(1)).retrieveAllUsers();
		
	}

	@Test
	public void testSaveAssetDetails() {
		Mockito.when(deviceDetailService.addDetails(trackingDetail)).thenReturn(trackingDetail);
		deviceDetailService.addDetails(trackingDetail);
		Mockito.verify(deviceDetailService, atLeast(1)).addUser(trackingDetail);
	}

}
*/