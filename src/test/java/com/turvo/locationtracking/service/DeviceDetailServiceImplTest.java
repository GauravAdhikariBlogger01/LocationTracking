package com.turvo.locationtracking.service;

import static org.mockito.Mockito.atLeast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.turvo.locationtracking.domain.TrackingDetail;
import com.turvo.locationtracking.modal.TrackingDetailModel;
import com.turvo.locationtracking.repository.DeviceDetailsRepository;

@RunWith(MockitoJUnitRunner.class)
public class DeviceDetailServiceImplTest {

	@Mock
	DeviceDetailsRepository deviceDetailsRepository;

	private TrackingDetail trackingDetail;
	private List<TrackingDetail> trackingDetailList;
	Long deviceid = 12L;

	@Before
	public void setUp() throws Exception {
		trackingDetail = new TrackingDetail();
		trackingDetail.setAdditionalInfo("abc");
		trackingDetail.setDeviceId(1L);
		trackingDetail.setLatitude(34L);
		trackingDetail.setLongitude(50L);
		trackingDetail.setSpeed(78L);
		trackingDetail.setTimestamp(new Date());

		trackingDetailList = new ArrayList<>();
		trackingDetailList.add(trackingDetail);

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddDetails() {
		Mockito.when(deviceDetailsRepository.save(trackingDetail)).thenReturn(trackingDetail);
		deviceDetailsRepository.save(trackingDetail);
		Mockito.verify(deviceDetailsRepository, atLeast(1)).save(trackingDetail);
	}

	@Test
	public void testGetRecordbyDeviceId() {

		Mockito.when(deviceDetailsRepository.findByDeviceId(deviceid)).thenReturn(trackingDetailList);
		trackingDetailList = deviceDetailsRepository.findByDeviceId(deviceid);
		Mockito.verify(deviceDetailsRepository, atLeast(1)).findByDeviceId(deviceid);
	}

	@Ignore
	@Test
	public void testGetRecordbytime() {
		// deviceDetailsRepository.findByTime(starttime, endtime);
	}

}
