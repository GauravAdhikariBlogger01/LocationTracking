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
	void addDetails(TrackingDetailModel trackingDetailModel);

	/**
	 * get all record by device id or asset id.
	 * 
	 * @param deviceid
	 *            {@link Long}.
	 * @return [{@link TrackingDetailModel}.
	 */
	List<TrackingDetailModel> getRecordbyDeviceId(Long deviceid);

	/**
	 * get all location of devices recorded between start time and end time.
	 * 
	 * @param starttime
	 *            {@value of type date}
	 * @param endtime
	 *            {@value of type date}
	 * @return [{@link TrackingDetailModel}.
	 */

	List<TrackingDetailModel> getRecordbytime(Date starttime, Date endtime);

}
