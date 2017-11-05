package com.turvo.locationtracking.service;

import static org.mockito.Mockito.atLeast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.turvo.locationtracking.domain.DriverVehicleRegistration;
import com.turvo.locationtracking.domain.TrackingDetails;
import com.turvo.locationtracking.modal.TrackingDetailModel;
import com.turvo.locationtracking.repository.DriverVehicleRegistrationRepository;
import com.turvo.locationtracking.repository.TrackingDetailRepository;;

@RunWith(MockitoJUnitRunner.class)
public class TrackingDetailServiceTest {

	@Mock
	TrackingDetailRepository trackingDetailRepository;

	@Mock
	DriverVehicleRegistrationRepository driverVehicleRegistrationRepository;

	@InjectMocks
	TrackingDetailService trackingDetailService = new TrackingDetailServiceImpl();

	private TrackingDetailModel trackingDetailModel;

	private DriverVehicleRegistration driverVehicleRegistration, exptectedDriverVehicleRegistration;

	private TrackingDetails trackingDetails;

	private List<TrackingDetailModel> trackingDetailModelList;
	Long deviceid = 12L;

	@Before
	public void setUp() throws Exception {

		trackingDetailModel = new TrackingDetailModel();
		trackingDetailModel.setAdditionalInfo("abc");
		trackingDetailModel.setAssetId(1L);
		trackingDetailModel.setLatitude((float) 34L);
		trackingDetailModel.setLongitude((float) 50L);
		trackingDetailModel.setSpeed((float) 78L);
		trackingDetailModelList = new ArrayList<>();
		trackingDetailModelList.add(trackingDetailModel);

		driverVehicleRegistration = new DriverVehicleRegistration();
		driverVehicleRegistration.setDriverId(101l);
		driverVehicleRegistration.setVehicleId(1001l);
		driverVehicleRegistration.setDriverName("gaurav");

		exptectedDriverVehicleRegistration = new DriverVehicleRegistration();
		exptectedDriverVehicleRegistration.setDriverId(101l);
		exptectedDriverVehicleRegistration.setVehicleId(1001l);
		exptectedDriverVehicleRegistration.setDriverName("gaurav");

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddDetailsFromMobile() {
		Mockito.when(driverVehicleRegistrationRepository.findByAssetId(trackingDetailModel.getAssetId(), true))
				.thenReturn(driverVehicleRegistration);

		TrackingDetails trackingDetails = new TrackingDetails();
		trackingDetails.setDeviceId(driverVehicleRegistration.getDriverId());
		trackingDetails.setVehicleId(driverVehicleRegistration.getVehicleId());
		trackingDetails.setDriverName(driverVehicleRegistration.getDriverName());

		Mockito.doNothing().when(trackingDetailRepository).save(trackingDetails);

		DriverVehicleRegistration driverVehicleRegistration = driverVehicleRegistrationRepository
				.findByAssetId(trackingDetailModel.getAssetId(), true);

		trackingDetailRepository.save(trackingDetails);
		// verify

		Assert.assertSame(exptectedDriverVehicleRegistration, driverVehicleRegistration);
	}

	/*
	 * @Test public void testSaveLocationTrackingRecord() {
	 * 
	 * Mockito.when(driverVehicleRegistrationRepository.
	 * findByAssetId(trackingDetailModel.getAssetId(), true))
	 * .thenReturn(driverVehicleRegistration);
	 * 
	 * TrackingDetails trackingDetails = new TrackingDetails();
	 * trackingDetails.setDeviceId(driverVehicleRegistration.getDriverId());
	 * trackingDetails.setVehicleId(driverVehicleRegistration.getVehicleId());
	 * trackingDetails.setDriverName(driverVehicleRegistration.getDriverName());
	 * 
	 * Mockito.doNothing().when(trackingDetailRepository).save(trackingDetails);
	 * 
	 * DriverVehicleRegistration driverVehicleRegistration =
	 * driverVehicleRegistrationRepository
	 * .findByAssetId(trackingDetailModel.getAssetId(), true);
	 * 
	 * 
	 * trackingDetailRepository.save(trackingDetails); //verify
	 * 
	 * Assert.assertSame(exptectedDriverVehicleRegistration,
	 * driverVehicleRegistration);
	 * 
	 * 
	 * }
	 */

	/*
	 * @Test public void testAddDetails() {
	 * Mockito.when(deviceDetailsRepository.save(trackingDetail)).thenReturn(
	 * trackingDetail); deviceDetailsRepository.save(trackingDetail);
	 * Mockito.verify(deviceDetailsRepository, atLeast(1)).save(trackingDetail); }
	 * 
	 * @Test public void testGetRecordbyDeviceId() {
	 * 
	 * Mockito.when(deviceDetailsRepository.findByDeviceId(deviceid)).thenReturn(
	 * trackingDetailList); trackingDetailList =
	 * deviceDetailsRepository.findByDeviceId(deviceid);
	 * Mockito.verify(deviceDetailsRepository, atLeast(1)).findByDeviceId(deviceid);
	 * }
	 * 
	 * @Ignore
	 * 
	 * @Test public void testGetRecordbytime() { //
	 * deviceDetailsRepository.findByTime(starttime, endtime); }
	 */
}
