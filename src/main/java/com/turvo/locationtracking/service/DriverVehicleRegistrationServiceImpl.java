package com.turvo.locationtracking.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turvo.locationtracking.domain.DriverVehicleRegistration;
import com.turvo.locationtracking.modal.DriverVehicleRegistrationModel;
import com.turvo.locationtracking.repository.DriverVehicleRegistrationRepository;

/**
 * Driver and vehicle registration service implementation.
 * 
 * @author gaurava
 *
 */
@Service
public class DriverVehicleRegistrationServiceImpl implements DriverVehicleRegistrationService {

	@Autowired
	DriverVehicleRegistrationRepository driverVehicleRegistrationRepository;

	/**
	 * Saving driver and vechile details.
	 */
	@Override
	public void addDriverVehicleRegistrationDetails(DriverVehicleRegistrationModel deviceVehicleRegistrationModel) {
		// TODO Auto-generated method stub

		DriverVehicleRegistration driverVehicleRegistrationDetails = new DriverVehicleRegistration();
		driverVehicleRegistrationDetails.setDriverName(deviceVehicleRegistrationModel.getDriverName());
		driverVehicleRegistrationDetails.setMobileNo(deviceVehicleRegistrationModel.getMobileNumber());
		driverVehicleRegistrationDetails.setRegistrationTime(new Date());
		driverVehicleRegistrationDetails.setVehicleId(deviceVehicleRegistrationModel.getVehicleId());
		driverVehicleRegistrationDetails.setStatus(deviceVehicleRegistrationModel.getStatus());
		driverVehicleRegistrationRepository.save(driverVehicleRegistrationDetails);
	}

}
