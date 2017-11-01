package com.turvo.locationtracking.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turvo.locationtracking.domain.TrackingDetail;
import com.turvo.locationtracking.modal.TrackingDetailModel;
import com.turvo.locationtracking.repository.DeviceDetailsRepository;

@Service("deviceDetailService")
public class DeviceDetailServiceImpl implements DeviceDetailService {
	/**
	 * Atowiring {@link DeviceDetailsRepository}.
	 */
	@Autowired
	DeviceDetailsRepository deviceDetailsRepository;

	@Override
	public void addDetails(TrackingDetailModel trackingDetailModel) {
		// TODO Auto-generated method stub
		TrackingDetail trackingDetail = new TrackingDetail();
		trackingDetail.setAdditionalInfo(trackingDetailModel.getAdditionalInfo());
		trackingDetail.setDeviceId(trackingDetailModel.getDeviceId());
		trackingDetail.setLatitude(trackingDetailModel.getLatitude());
		trackingDetail.setLongitude(trackingDetailModel.getLongitude());
		trackingDetail.setSpeed(trackingDetailModel.getSpeed());
		trackingDetail.setDriverId(trackingDetailModel.getDriverId());
		trackingDetail.setTimestamp(new Date());
		deviceDetailsRepository.save(trackingDetail);

	}

	@Override
	public List<TrackingDetailModel> getRecordbyDeviceId(Long deviceid) {
		// TODO Auto-generated method stub
		List<TrackingDetailModel> trackingDetailModel = new ArrayList<>();
		List<TrackingDetail> trackingDetail = deviceDetailsRepository.findByDeviceId(deviceid);
		if (!trackingDetail.isEmpty()) {
			for (TrackingDetail trackingDetail2 : trackingDetail) {
				TrackingDetailModel detailModel = new TrackingDetailModel();
				detailModel.setAdditionalInfo(trackingDetail2.getAdditionalInfo());
				detailModel.setLatitude(trackingDetail2.getLatitude());
				detailModel.setLongitude(trackingDetail2.getLongitude());
				detailModel.setSpeed(trackingDetail2.getSpeed());
				detailModel.setTimeststamp(trackingDetail2.getTimestamp());
				detailModel.setAdditionalInfo(trackingDetail2.getAdditionalInfo());
				trackingDetailModel.add(detailModel);
			}
		}
		return trackingDetailModel;
	}

	public List<TrackingDetailModel> getRecordbytime(Date starttime, Date endtime) {
		List<TrackingDetailModel> trackingDetailModel = new ArrayList<>();
		List<TrackingDetail> trackingDetail = deviceDetailsRepository.findByTime(starttime, endtime);
		if (!trackingDetail.isEmpty()) {
			for (TrackingDetail trackobj : trackingDetail) {
				TrackingDetailModel detailModel = new TrackingDetailModel();
				detailModel.setAdditionalInfo(trackobj.getAdditionalInfo());
				detailModel.setLatitude(trackobj.getLatitude());
				detailModel.setLongitude(trackobj.getLongitude());
				detailModel.setSpeed(trackobj.getSpeed());
				detailModel.setTimeststamp(trackobj.getTimestamp());
				detailModel.setAdditionalInfo(trackobj.getAdditionalInfo());
				trackingDetailModel.add(detailModel);
			}
		}
		return trackingDetailModel;
	}

}
