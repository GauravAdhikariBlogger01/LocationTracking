package com.turvo.locationtracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.turvo.locationtracking.modal.CurrentLocationModel;
import com.turvo.locationtracking.service.CurrentLocationDetailService;
/**
 * Controller Class to save latest tracking data.
 * @author gaurava
 *
 */
@Controller
public class CurrentLocationTrackingController {

	@Autowired
	CurrentLocationDetailService driverDetailService;

	@PostMapping(value = "/addDriverDevice")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void saveAssetDetails(@RequestBody CurrentLocationModel driverDetailModel) {

		driverDetailService.addDetails(driverDetailModel);

	}
}
