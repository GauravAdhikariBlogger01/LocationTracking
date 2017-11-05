package com.turvo.locationtracking.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Driver vehicle registration table mapping class.
 * @author gaurava
 *
 */
@Entity
@Table(name = "driver_vehicle_registration")
public class DriverVehicleRegistration implements Serializable {
	/**
	 * Domain mapping class for driver and vehicle registration detail table.
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "driver_id")
	private Long driverId;

	@Column(name = "mobile_no",unique = true)
	private Long mobileNo;

	@Column(name = "driver_name")
	private String driverName;

	@Column(name = "vehicle_id")
	private Long vehicleId;

	@Column(name = "registration_time")
	private Date registrationTime;

	@Column(name = "status")
	private Boolean status;

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
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

	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date date) {
		this.registrationTime = date;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}
}
