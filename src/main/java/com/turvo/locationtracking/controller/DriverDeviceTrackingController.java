package com.turvo.locationtracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.turvo.locationtracking.modal.DriverDetailModel;
import com.turvo.locationtracking.service.DriverDetailService;

@Controller
public class DriverDeviceTrackingController {

	@Autowired
	DriverDetailService driverDetailService;

	@PostMapping(value = "/addDriverDevice")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void saveAssetDetails(@RequestBody DriverDetailModel driverDetailModel) {

		driverDetailService.addDetails(driverDetailModel);

	}
}
