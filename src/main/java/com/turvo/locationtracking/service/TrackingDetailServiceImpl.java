package com.turvo.locationtracking.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turvo.locationtracking.domain.DeviceRegistration;
import com.turvo.locationtracking.domain.DriverVehicleRegistration;
import com.turvo.locationtracking.domain.TrackingDetails;
import com.turvo.locationtracking.exception.DetailNotFoundException;
import com.turvo.locationtracking.modal.DriverVehicleRegistrationModel;
import com.turvo.locationtracking.modal.ResponseTrackingDetailModel;
import com.turvo.locationtracking.modal.TrackingDetailModel;
import com.turvo.locationtracking.repository.DeviceRegistrationRepository;
import com.turvo.locationtracking.repository.DriverVehicleRegistrationRepository;
import com.turvo.locationtracking.repository.TrackingDetailRepository;

/**
 * Tracking detail service implementation.
 * 
 * @author gaurava
 *
 */
@Service
public class TrackingDetailServiceImpl implements TrackingDetailService {

	@Autowired
	TrackingDetailRepository trackingDetailRepository;
	@Autowired
	DriverVehicleRegistrationRepository driverVehicleRegistrationRepository;
	@Autowired
	DeviceRegistrationRepository deviceRegistrationRepository;

	/**
	 * check the device type and saving tracking data.
	 * 
	 */
	@Override
	public void addtrackingdetails(TrackingDetailModel trackingDetailModel) {

		if (trackingDetailModel.getDeviceType().equals("Mobile")) {
			addDetailsFromMobile(trackingDetailModel);
		} else {
			addDetailsFromOthers(trackingDetailModel);

		}

	}

	/**
	 * Saving tracking information send by device other than mobile.
	 * 
	 * @param trackingDetailModel
	 *            data model send by device.
	 */
	private void addDetailsFromOthers(TrackingDetailModel trackingDetailModel) {

		DeviceRegistration deviceRegistrationDetails = deviceRegistrationRepository
				.findOne(trackingDetailModel.getAssetId());
		Long vechileId = deviceRegistrationDetails.getVehicleId();
		boolean status = true;

		DriverVehicleRegistration driverVehicleRegistrationDetail = driverVehicleRegistrationRepository
				.findByVechileIdAndStatus(vechileId, status);
		if (driverVehicleRegistrationDetail != null) {
			TrackingDetails trackingDetail = new TrackingDetails();
			trackingDetail.setDriverName(driverVehicleRegistrationDetail.getDriverName());
			trackingDetail.setVehicleId(driverVehicleRegistrationDetail.getVehicleId());
			trackingDetail.setAdditionalInfo(trackingDetailModel.getAdditionalInfo());
			trackingDetail.setEventtime(new Date());
			trackingDetail.setLatitude(trackingDetailModel.getLatitude());
			trackingDetail.setLongitude(trackingDetailModel.getLongitude());
			trackingDetail.setSpeed(trackingDetailModel.getSpeed());
			trackingDetail.setDeviceType(trackingDetailModel.getDeviceType());
			trackingDetail.setDeviceId(trackingDetailModel.getAssetId());
			trackingDetail.setDriverId(driverVehicleRegistrationDetail.getDriverId());
			trackingDetailRepository.save(trackingDetail);
		} else {
			throw new DetailNotFoundException(trackingDetailModel.getAssetId(), "Asset(GPS) Details not found");
		}

	}

	/**
	 * Saving tracking information send by mobile device.
	 * 
	 * @param trackingDetailModel
	 *            data model send by mobile device.
	 */
	private void addDetailsFromMobile(TrackingDetailModel trackingDetailModel) {
		boolean status = true;
		DriverVehicleRegistration driverVehicleRegistrationDetail = driverVehicleRegistrationRepository
				.findByAssetId(trackingDetailModel.getAssetId(), status);

		if (null != driverVehicleRegistrationDetail) {

			TrackingDetails trackingDetail = new TrackingDetails();
			trackingDetail.setDriverName(driverVehicleRegistrationDetail.getDriverName());
			trackingDetail.setVehicleId(driverVehicleRegistrationDetail.getVehicleId());
			trackingDetail.setAdditionalInfo(trackingDetailModel.getAdditionalInfo());
			trackingDetail.setEventtime(new Date());
			trackingDetail.setLatitude(trackingDetailModel.getLatitude());
			trackingDetail.setLongitude(trackingDetailModel.getLongitude());
			trackingDetail.setSpeed(trackingDetailModel.getSpeed());
			trackingDetail.setDeviceType(trackingDetailModel.getDeviceType());
			trackingDetail.setDeviceId(trackingDetailModel.getAssetId());
			trackingDetail.setDriverId(driverVehicleRegistrationDetail.getDriverId());
			trackingDetailRepository.save(trackingDetail);
		} else {
			throw new DetailNotFoundException(trackingDetailModel.getAssetId(), "Driver Details not found");
		}

	}

	/**
	 * Getting consolidated tracking data from database on the basis of device id
	 * and driver id.
	 */
	@Override
	public List<ResponseTrackingDetailModel> getTrackingDetailByTimeSpanAndDeviceIdAndDriverId(Date starttime,
			Date endtime, Long deviceId, Long driverId) {
		List<ResponseTrackingDetailModel> responseTrackingDetailModel = new ArrayList<>();

		List<TrackingDetails> trackingDetails = trackingDetailRepository.findByTimeAndDeviceIdAndDriverId(starttime,
				endtime, deviceId, driverId);
		if (!trackingDetails.isEmpty()) {
			responseTrackingDetailModel = createTrackingDetailModel(trackingDetails);
		} else {
			throw new DetailNotFoundException(deviceId, "Please check the search criteriea");
		}

		return responseTrackingDetailModel;

	}

	/**
	 * Creating response of tracking details.
	 * 
	 * @param trackingDetails
	 *            {@value data from tracking detail table.}
	 * @return {@value list of ResponseTrackingDetailModel object.}
	 */
	private List<ResponseTrackingDetailModel> createTrackingDetailModel(List<TrackingDetails> trackingDetails) {

		List<ResponseTrackingDetailModel> responseTrackingDetailModel = new ArrayList<>();
		for (TrackingDetails trackingDetail : trackingDetails) {

			ResponseTrackingDetailModel detailModel = new ResponseTrackingDetailModel();
			detailModel.setAdditionalInfo(trackingDetail.getAdditionalInfo());
			detailModel.setLatitude(trackingDetail.getLatitude());
			detailModel.setLongitude(trackingDetail.getLongitude());
			detailModel.setSpeed(trackingDetail.getSpeed());

			Date eventTime = trackingDetail.getEventtime();
			SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateText = df2.format(eventTime);
			detailModel.setTimeststamp(dateText);
			System.out.println(dateText);
			detailModel.setAdditionalInfo(trackingDetail.getAdditionalInfo());
			detailModel.setDeviceId(trackingDetail.getDeviceId());
			detailModel.setVechileId(trackingDetail.getVehicleId());
			detailModel.setDriverName(trackingDetail.getDriverName());
			detailModel.setDeviceType(trackingDetail.getDeviceType());
			responseTrackingDetailModel.add(detailModel);
		}
		return responseTrackingDetailModel;
	}

}
