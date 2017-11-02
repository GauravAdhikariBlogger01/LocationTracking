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

/**
 * Device detail service implementation.
 * 
 * @author gaurava
 *
 */
@Service("deviceDetailService")
public class DeviceDetailServiceImpl implements DeviceDetailService {
	
	@Autowired
	DeviceDetailsRepository deviceDetailsRepository;

	/**
	 * Add device tracking details.
	 */
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

	/**
	 * get all tracking details by device id.
	 */
	@Override
	public List<TrackingDetailModel> getTrackingDetailsByDeviceId(Long deviceid) {
		// TODO Auto-generated method stub
		List<TrackingDetailModel> trackingDetailModel = new ArrayList<>();
		List<TrackingDetail> trackingDetails = deviceDetailsRepository.findByDeviceId(deviceid);
		if (!trackingDetails.isEmpty()) {
			trackingDetailModel = createTrackingDetailModel(trackingDetails);
		}
		return trackingDetailModel;
	}

	/**
	 * Common implementation for creating modal.
	 * 
	 * @param trackingDetails
	 *            {@link}TrackingDetail}
	 * @return
	 */
	private List<TrackingDetailModel> createTrackingDetailModel(List<TrackingDetail> trackingDetails) {
		List<TrackingDetailModel> trackingDetailModel = new ArrayList<>();
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
			trackingDetailModel.add(detailModel);
		}
		return trackingDetailModel;
	}

	/**
	 * get all tracking details for a period of time
	 */
	@Override
	public List<TrackingDetailModel> getTrackingDetailByTimeSpan(Date starttime, Date endtime) {
		List<TrackingDetailModel> trackingDetailModel = new ArrayList<>();
		List<TrackingDetail> trackingDetails = deviceDetailsRepository.findByTime(starttime, endtime);
		if (!trackingDetails.isEmpty()) {
			trackingDetailModel = createTrackingDetailModel(trackingDetails);
		}
		return trackingDetailModel;
	}

	/**
	 * get all tracking details by device id for a period of time..
	 */
	@Override
	public List<TrackingDetailModel> getTrackingDetailByTimeSpanAndDeviceId(Date starttime, Date endtime,
			Long deviceId) {
		List<TrackingDetailModel> trackingDetailModel = new ArrayList<>();
		List<TrackingDetail> trackingDetails = deviceDetailsRepository.findByTimeAndDeviceId(starttime, endtime,
				deviceId);
		if (!trackingDetails.isEmpty()) {
			trackingDetailModel = createTrackingDetailModel(trackingDetails);
		}
		return trackingDetailModel;

	}

	/**
	 * get all tracking details by device id,driver id for a duration of time.
	 */
	@Override
	public List<TrackingDetailModel> getTrackingDetailByTimeSpanAndDeviceIdAndDriverId(Date starttime, Date endtime,
			Long deviceId, Long driverId) {
		List<TrackingDetailModel> trackingDetailModel = new ArrayList<>();
		List<TrackingDetail> trackingDetails = deviceDetailsRepository.findByTimeAndDeviceIdAndDriverId(starttime,
				endtime, deviceId, driverId);
		if (!trackingDetails.isEmpty()) {
			trackingDetailModel = createTrackingDetailModel(trackingDetails);
		}
		return trackingDetailModel;
	}
}
