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
	public void addTrackingDetails(TrackingDetailModel trackingDetailModel) {
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
	public List<TrackingDetailModel> getTrackingDetailsByDeviceId(Long deviceid) {
		// TODO Auto-generated method stub
		List<TrackingDetailModel> trackingDetailModel = new ArrayList<>();
		List<TrackingDetail> trackingDetails = deviceDetailsRepository.findByDeviceId(deviceid);
		if (!trackingDetails.isEmpty()) {
			for (TrackingDetail trackingDetail : trackingDetails) {
				TrackingDetailModel detailModel = new TrackingDetailModel();
				detailModel.setAdditionalInfo(trackingDetail.getAdditionalInfo());
				detailModel.setLatitude(trackingDetail.getLatitude());
				detailModel.setLongitude(trackingDetail.getLongitude());
				detailModel.setSpeed(trackingDetail.getSpeed());
				detailModel.setTimeststamp(trackingDetail.getTimestamp());
				detailModel.setAdditionalInfo(trackingDetail.getAdditionalInfo());
				detailModel.setDeviceId(trackingDetail.getDeviceId());
				detailModel.setDeviceId(trackingDetail.getDriverId());
				trackingDetailModel.add(detailModel);
			}
		}
		return trackingDetailModel;
	}

	public List<TrackingDetailModel> getTrackingDetailByTimeSpan(Date starttime, Date endtime) {
		List<TrackingDetailModel> trackingDetailModels = new ArrayList<>();
		List<TrackingDetail> trackingDetails = deviceDetailsRepository.findByTime(starttime, endtime);
		if (!trackingDetails.isEmpty()) {
			for (TrackingDetail trackingDetail : trackingDetails) {
				TrackingDetailModel detailModel = new TrackingDetailModel();
				detailModel.setAdditionalInfo(trackingDetail.getAdditionalInfo());
				detailModel.setLatitude(trackingDetail.getLatitude());
				detailModel.setLongitude(trackingDetail.getLongitude());
				detailModel.setSpeed(trackingDetail.getSpeed());
				detailModel.setTimeststamp(trackingDetail.getTimestamp());
				detailModel.setAdditionalInfo(trackingDetail.getAdditionalInfo());
				detailModel.setDeviceId(trackingDetail.getDeviceId());
				detailModel.setDriverId(trackingDetail.getDriverId());
				trackingDetailModels.add(detailModel);
			}
		}
		return trackingDetailModels;
	}

	@Override
	public List<TrackingDetailModel> getTrackingDetailByTimeSpanAndDeviceId(Date starttime, Date endtime, Long deviceId) {
		List<TrackingDetailModel> trackingDetailModel = new ArrayList<>();
		List<TrackingDetail> trackingDetails = deviceDetailsRepository.findByTimeAndDeviceId(starttime, endtime,
				deviceId);
		if (!trackingDetails.isEmpty()) {
			for (TrackingDetail trackobj : trackingDetails) {
				TrackingDetailModel detailModel = new TrackingDetailModel();
				detailModel.setAdditionalInfo(trackobj.getAdditionalInfo());
				detailModel.setLatitude(trackobj.getLatitude());
				detailModel.setLongitude(trackobj.getLongitude());
				detailModel.setSpeed(trackobj.getSpeed());
				detailModel.setTimeststamp(trackobj.getTimestamp());
				detailModel.setAdditionalInfo(trackobj.getAdditionalInfo());
				detailModel.setDeviceId(trackobj.getDeviceId());
				detailModel.setDriverId(trackobj.getDriverId());
				trackingDetailModel.add(detailModel);
			}
		}
		return trackingDetailModel;

	}
}
