package com.turvo.locationtracking.modal;

import java.util.Date;

/**
 * Driver vehicle registration data model.
 * 
 * @author gaurava
 *
 */
public class DriverVehicleRegistrationModel {
	private Date timeststamp;
	private String driverName;
	private Long mobileNumber;
	private Long vehicleId;
	private Boolean status;

	public Date getTimeststamp() {
		return timeststamp;
	}

	public void setTimeststamp(Date timeststamp) {
		this.timeststamp = timeststamp;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
