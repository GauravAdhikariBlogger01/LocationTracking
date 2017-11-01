package com.turvo.locationtracking.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turvo.locationtracking.domain.CurrentAssetLocation;
import com.turvo.locationtracking.domain.Driverid;
import com.turvo.locationtracking.domain.TrackingDetail;
import com.turvo.locationtracking.modal.CurrentLocationModel;
import com.turvo.locationtracking.repository.DeviceDetailsRepository;
import com.turvo.locationtracking.repository.CurrentAssetLocationDetailRepository;

@Service
public class CurrentLocationDetailServiceImpl  implements CurrentLocationDetailService {

	
	@Autowired
	CurrentAssetLocationDetailRepository driverDetailRepository;
	
	@Override
	public void addDetails(CurrentLocationModel driverDetailModel) {
		// TODO Auto-generated method stub
		CurrentAssetLocation trackingDetail = new CurrentAssetLocation();
		Driverid driverid =new Driverid(driverDetailModel.getDriverId(), driverDetailModel.getMobileNumber());
		trackingDetail.setAdditionalInfo(driverDetailModel.getAdditionalInfo());
		trackingDetail.setDriver(driverid);
		trackingDetail.setDeviceid(driverDetailModel.getDeviceId());
		trackingDetail.setLatitude(driverDetailModel.getLatitude());
		trackingDetail.setLongitude(driverDetailModel.getLongitude());
		trackingDetail.setSpeed(driverDetailModel.getSpeed());
		trackingDetail.setTimestamp(new Date());
		driverDetailRepository.save(trackingDetail);
	}

}
