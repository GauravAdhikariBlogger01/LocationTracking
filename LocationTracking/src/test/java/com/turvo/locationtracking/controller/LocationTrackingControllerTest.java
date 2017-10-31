package com.turvo.locationtracking.controller;

import static org.mockito.Mockito.atLeast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;

import com.turvo.locationtracking.modal.TrackingDetailModel;
import com.turvo.locationtracking.service.DeviceDetailService;

@RunWith(MockitoJUnitRunner.class)
public class LocationTrackingControllerTest {

	@Mock
	LocationTrackingController locationTrackingController;

	@Mock
	DeviceDetailService deviceDetailService;

	private List<TrackingDetailModel> recordByDeviceId;

	private TrackingDetailModel trackingDetail;

	// private Date starttime = "2012-02-01 00:00:00";
	// private Date endtime = "2017-10-31 06:54:58";

	@Before
	public void setUpBeforeClass() throws Exception {
		recordByDeviceId = new ArrayList<>();
		TrackingDetailModel trackingDetail = new TrackingDetailModel();
		trackingDetail.setAdditionalInfo("Test Details");
		trackingDetail.setLatitude(1l);
		trackingDetail.setLongitude(2l);
		trackingDetail.setSpeed(5l);
		recordByDeviceId.add(trackingDetail);
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
	public void testGetDetailByDevice() {

		Mockito.when(deviceDetailService.getRecordbyDeviceId(1l)).thenReturn(recordByDeviceId);
		recordByDeviceId = deviceDetailService.getRecordbyDeviceId(1l);
		Mockito.verify(deviceDetailService, atLeast(1)).getRecordbyDeviceId(1l);

	}

	@Ignore
	@Test
	public void testSaveAssetDetails() {
		/*
		 * Mockito.when(deviceDetailService.getRecordbytime(starttime,
		 * endtime)).thenReturn(trackingDetail);
		 * deviceDetailService.getRecordbytime(starttime, endtime);
		 * Mockito.verify(deviceDetailService, atLeast(1)).getRecordbytime(starttime,
		 * endtime);
		 */
	}

}

