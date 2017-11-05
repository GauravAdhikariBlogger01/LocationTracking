package com.turvo.locationtracking.modal;

import java.util.Date;

/**
 * Response data model for tracking data.
 * 
 * @author gaurava
 *
 */
public class ResponseTrackingDetailModel {

	private Long deviceId;

	private Float latitude;

	private Float longitude;

	private Float speed;

	private String additionalInfo;

	private String timeststamp;

	private String driverName;

	private Long vehicleId;

	private String deviceType;

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getSpeed() {
		return speed;
	}

	public void setSpeed(Float speed) {
		this.speed = speed;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getTimeststamp() {
		return timeststamp;
	}

	public void setTimeststamp(String dateText) {
		this.timeststamp = dateText;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Long getVechileId() {
		return vehicleId;
	}

	public void setVechileId(Long vechileId) {
		this.vehicleId = vechileId;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

}
