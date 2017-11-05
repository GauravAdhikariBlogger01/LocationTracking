package com.turvo.locationtracking.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "device_registration")
public class DeviceRegistration implements Serializable {
	/**
	 * Domain mapping class for device registration table detail summary.
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "device_id")
	private Long deviceId;

	@Column(name = "description")
	private String driverName;

	@Column(name = "vehicle_id")
	private Long vehicleId;

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

}
