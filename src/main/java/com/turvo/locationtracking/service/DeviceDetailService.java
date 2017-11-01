package com.turvo.locationtracking.service;

import java.util.Date;
import java.util.List;

import com.turvo.locationtracking.modal.TrackingDetailModel;

public interface DeviceDetailService {

	/**
	 * Save details publish by asset attach to asset.
	 * 
	 * @param trackingDetailModel
	 *            {@link TrackingDetailModel}.
	 */
	void addTrackingDetails(TrackingDetailModel trackingDetailModel);

	/**
	 * get all record by device id or asset id.
	 * 
	 * @param deviceid
	 *            {@link Long}.
	 * @return [{@link TrackingDetailModel}.
	 */
	List<TrackingDetailModel> getTrackingDetailsByDeviceId(Long deviceid);

	/**
	 * get all location of devices recorded between start time and end time.
	 * 
	 * @param starttime
	 *            {@value of type date}
	 * @param endtime
	 *            {@value of type date}
	 * @return [{@link TrackingDetailModel}.
	 */

	List<TrackingDetailModel> getTrackingDetailByTimeSpan(Date starttime, Date endtime);

	/**
	 * get all location of selected devices recorded between start time and end
	 * time.
	 * 
	 * @param starttime
	 *            {@value of type date}
	 * @param endtime
	 *            {@value of type date}
	 * @param deviceId
	 *            {{@link long}
	 * @return {@link TrackingDetailModel}
	 */
	List<TrackingDetailModel> getTrackingDetailByTimeSpanAndDeviceId(Date starttime, Date endtime, Long deviceId);

	/**
	 * get all location of selected devices and driver recorded between start time
	 * and end time.
	 * 
	 * @param starttime
	 *            {@value of type date}
	 * @param endtime
	 *            {@value of type date}
	 * @param deviceId
	 *            {{@link long}
	 * @param driverId
	 *            {{@link long}
	 * @return {@link TrackingDetailModel}
	 */
	List<TrackingDetailModel> getTrackingDetailByTimeSpanAndDeviceIdAndDriverId(Date starttime, Date endtime,
			Long deviceId, Long driverId);

}
