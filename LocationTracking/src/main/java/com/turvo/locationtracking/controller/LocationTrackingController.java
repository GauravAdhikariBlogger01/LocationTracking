package com.turvo.locationtracking.controller;

import java.util.Date;
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
import com.turvo.locationtracking.modal.TrackingDetailModel;
import com.turvo.locationtracking.service.DeviceDetailService;

@Controller
public class LocationTrackingController {

	@Autowired
	DeviceDetailService deviceDetailService;

	/**
	 * To load Home page url,get request.
	 * 
	 * @param model
	 * @return string jsp page name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		model.put("name", "gaurav");
		return "welcome";
	}

	/**
	 * get detail of particular device or asset on basis of device/assetid.
	 * 
	 * @param deviceid
	 *            of type long;
	 * @return list of record.
	 */
	@GetMapping(value = "/getCall/{deviceid}")
	public ResponseEntity<List<TrackingDetailModel>> getDetailByDevice(@PathVariable("deviceid") Long deviceid) {

		List<TrackingDetailModel> recordbydeviceid = deviceDetailService.getRecordbyDeviceId(deviceid);
		if (recordbydeviceid.isEmpty()) {
			return new ResponseEntity<List<TrackingDetailModel>>(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<List<TrackingDetailModel>>(recordbydeviceid, HttpStatus.OK);
	}

	/**
	 * get detail of particular device or asset on basis of time duration.
	 * 
	 * @param endtime
	 *            of type date,
	 * @return list of record.
	 */
	@GetMapping(value = "/getCall/{starttime}/{endtime}")
	public ResponseEntity<List<TrackingDetailModel>> getDetailByTime(
			@PathVariable("starttime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date starttime,
			@PathVariable("endtime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endtime) {

		List<TrackingDetailModel> recordbytime = deviceDetailService.getRecordbytime(starttime, endtime);
		if (recordbytime.isEmpty()) {
			return new ResponseEntity<List<TrackingDetailModel>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TrackingDetailModel>>(recordbytime, HttpStatus.OK);
	}

	/**
	 * Save the details publish by asset.
	 * 
	 * @param trackingDetailModel
	 *            of type json object.
	 */
	@PostMapping(value = "/add")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void saveAssetDetails(@RequestBody TrackingDetailModel trackingDetailModel) {

		deviceDetailService.addDetails(trackingDetailModel);
	}

}