package com.turvo.locationtracking.service;

import java.util.Date;
import java.util.List;

import com.turvo.locationtracking.modal.ResponseTrackingDetailModel;
import com.turvo.locationtracking.modal.TrackingDetailModel;

/**
 * Tracking detail service.
 * 
 * @author gaurava
 *
 */
public interface TrackingDetailService {

	void addtrackingdetails(TrackingDetailModel trackingDetailModel);

	List<ResponseTrackingDetailModel> getTrackingDetailByTimeSpanAndDeviceIdAndDriverId(Date starttime, Date endtime,
			Long deviceId, Long driverId);

}
