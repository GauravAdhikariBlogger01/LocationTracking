package com.turvo.locationtracking.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Embedded id or composite id.
 * 
 * @author gaurava
 *
 */

public class DriverId implements Serializable {

	/**
	 * composite key creation.
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "driver_id")
	private Long driver_id;
	@Column(name = "mobileno")
	private Long mobileno;

	public Long getDriver_id() {
		return driver_id;
	}

	public void setDriver_id(Long driver_id) {
		this.driver_id = driver_id;
	}

	public Long getMobileno() {
		return mobileno;
	}

	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}

	public DriverId(Long driver_id, Long mobileno) {
		this.driver_id = driver_id;
		this.mobileno = mobileno;
	}

	DriverId() {

	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		DriverId taskId1 = (DriverId) o;
		if (driver_id != taskId1.driver_id)
			return false;
		return mobileno == taskId1.mobileno;
	}

	@Override
	public int hashCode() {
		return Objects.hash(driver_id, mobileno);
	}

}
