package com.turvo.locationtracking.controller;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;

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

import com.turvo.locationtracking.modal.DriverVehicleRegistrationModel;
import com.turvo.locationtracking.modal.TrackingDetailModel;
import com.turvo.locationtracking.service.DriverVehicleRegistrationService;
import com.turvo.locationtracking.service.TrackingDetailService;

@RunWith(MockitoJUnitRunner.class)
public class LocationTrackingControllerTest {

	@Mock
	LocationTrackingController locationTrackingController;

	@Mock
	DriverVehicleRegistrationService driverVehicleRegistrationService;

	@Mock
	TrackingDetailService trackingDetailService;

	private List<TrackingDetailModel> recordByDeviceId;

	private TrackingDetailModel trackingDetail = null;

	private DriverVehicleRegistrationModel driverVehicleRegistrationModel = null;

	// private Date starttime = "2012-02-01 00:00:00";
	// private Date endtime = "2017-10-31 06:54:58";

	@Before
	public void setUp() throws Exception {
		recordByDeviceId = new ArrayList<>();
		trackingDetail = new TrackingDetailModel();
		trackingDetail.setAdditionalInfo("Test Details");
		trackingDetail.setLatitude((float) 1l);
		trackingDetail.setLongitude((float) 2l);
		trackingDetail.setSpeed((float) 5l);
		recordByDeviceId.add(trackingDetail);
		driverVehicleRegistrationModel = new DriverVehicleRegistrationModel();
		driverVehicleRegistrationModel.setDriverName("Gaurav");
		driverVehicleRegistrationModel.setMobileNumber(7416667463L);
		driverVehicleRegistrationModel.setStatus(true);
		driverVehicleRegistrationModel.setVehicleId(2001L);
		// Date date=new Date("2017-11-04 03:16:13");
		// driverVehicleRegistrationModel.setTimeststamp(dat);

		// locationTrackingController = new LocationTrackingController();
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
	public void testRegisterDriverInfo() {

		Mockito.doNothing().when(driverVehicleRegistrationService)
				.addDriverVehicleRegistrationDetails(driverVehicleRegistrationModel);
		locationTrackingController.registerDriverInfo(driverVehicleRegistrationModel);
		Mockito.verify(locationTrackingController, times(1)).registerDriverInfo(driverVehicleRegistrationModel);

	}
	/*
	 * @Test public void testGetDetailByDevice() {
	 * 
	 * Mockito.when(deviceDetailService.getTrackingDetailsByDeviceId(1l)).thenReturn
	 * (recordByDeviceId); recordByDeviceId =
	 * deviceDetailService.getTrackingDetailsByDeviceId(1l);
	 * Mockito.verify(deviceDetailService,
	 * atLeast(1)).getTrackingDetailsByDeviceId(1l);
	 * 
	 * }
	 * 
	 * @Ignore
	 * 
	 * @Test public void testSaveAssetDetails() {
	 * 
	 * Mockito.when(deviceDetailService.getRecordbytime(starttime,
	 * endtime)).thenReturn(trackingDetail);
	 * deviceDetailService.getRecordbytime(starttime, endtime);
	 * Mockito.verify(deviceDetailService, atLeast(1)).getRecordbytime(starttime,
	 * endtime);
	 * 
	 * }
	 */
}
