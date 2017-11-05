package com.turvo.locationtracking.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.turvo.locationtracking.modal.DriverVehicleRegistrationModel;
import com.turvo.locationtracking.modal.ResponseTrackingDetailModel;
import com.turvo.locationtracking.modal.TrackingDetailModel;
import com.turvo.locationtracking.service.DriverVehicleRegistrationService;
import com.turvo.locationtracking.service.TrackingDetailService;

@Controller
public class LocationTrackingController {

	@Autowired
	private DriverVehicleRegistrationService driverVehicleRegistrationService;

	@Autowired
	private TrackingDetailService trackingDetailService;

	/**
	 * To load Home page url,get request.
	 * 
	 * @param model
	 * @return string jsp page name.
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		model.put("name", "Welcome to Home Page");
		return "welcome";
	}

	/**
	 * Register Driver data.
	 * 
	 * @param driverVehicleRegistrationModel
	 *            {@value data send by user mobile device}
	 */
	@PostMapping(value = "/registration")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void registerDriverInfo(@RequestBody DriverVehicleRegistrationModel driverVehicleRegistrationModel) {
		driverVehicleRegistrationService.addDriverVehicleRegistrationDetails(driverVehicleRegistrationModel);
	}

	/**
	 * Saving tracking data send by different devices.
	 * 
	 * @param trackingDetailModel
	 *            {@value data send by different devices}
	 */
	@PostMapping(value = "/addTrackRecord")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void saveLocationTrackingRecord(@RequestBody TrackingDetailModel trackingDetailModel) {
		trackingDetailService.addtrackingdetails(trackingDetailModel);
	}

	/**
	 * Get tracking data of all vehicle on the basis of time slot,deviceId and
	 * driver Id.
	 * 
	 * @param starttime
	 *            {@value start time send by user of type time stamp}
	 * @param endtime
	 *            {@value end time send by user of type time stamp}
	 * @param deviceId{@value
	 * 			Device Id send by user of type Long}
	 * @param driverId
	 *            {@value Driver Id send by user of type Long}
	 * @return {@value Result dor specific device and driver,No of ping details}
	 * @throws ParseException
	 * @{@link Exception exception handling}
	 */
	@GetMapping(value = "/getTrackRecord/{starttime}/{endtime}/{deviceId}/{driverId}")
	public ResponseEntity<List<ResponseTrackingDetailModel>> getDetailByTimeAndDeviceAndDriver(
			@PathVariable("starttime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String starttime,
			@PathVariable("endtime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String endtime,
			@PathVariable("deviceId") Long deviceId, @PathVariable("driverId") Long driverId) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<ResponseTrackingDetailModel> recordbytime = trackingDetailService
				.getTrackingDetailByTimeSpanAndDeviceIdAndDriverId(dateFormat.parse(starttime),
						dateFormat.parse(endtime), deviceId, driverId);
		if (recordbytime.isEmpty()) {
			return new ResponseEntity<List<ResponseTrackingDetailModel>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ResponseTrackingDetailModel>>(recordbytime, HttpStatus.OK);
	}
}
