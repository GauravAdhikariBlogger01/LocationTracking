

INSERT INTO `LocationTracking`.`device_registration` (`device_id`, `description`, `vehicle_id`) VALUES ('1000', 'test', '2001');
INSERT INTO `LocationTracking`.`device_registration` (`device_id`, `description`, `vehicle_id`) VALUES ('1001', 'test2', '2002');
INSERT INTO `LocationTracking`.`device_registration` (`device_id`, `description`, `vehicle_id`) VALUES ('1002', 'test3', '2003');
INSERT INTO `LocationTracking`.`device_registration` (`device_id`, `description`, `vehicle_id`) VALUES ('1003', 'test4', '2004');

INSERT INTO `LocationTracking`.`driver_vehicle_registration` (`driver_id`, `driver_name`, `mobile_no`, `registration_time`, `status`, `vehicle_id`) VALUES ('2', 'gaurav', '7416667463', '2017-11-04 03:16:13', true , '2002');
INSERT INTO `LocationTracking`.`driver_vehicle_registration` (`driver_id`, `driver_name`, `mobile_no`, `registration_time`, `status`, `vehicle_id`) VALUES ('3', 'Mohan', '7416667464', '2017-11-04 03:16:13', true , '2003');


INSERT INTO `LocationTracking`.`tracking_detail_summary` (`tracking_id`,`additional_info`,`device_id`,`device_type`,`driver_id`,`driver_name`,`eventtime`,`latitude`,`longitude`,`speed`,`vechile_id`)
VALUES('2', 'Test', '1001', 'gps', '2', 'gaurav', '2017-11-04 11:09:15', '23435', '1012', '112', '2002');

INSERT INTO `LocationTracking`.`tracking_detail_summary` (`tracking_id`,`additional_info`,`device_id`,`device_type`,`driver_id`,`driver_name`,`eventtime`,`latitude`,`longitude`,`speed`,`vechile_id`)
VALUES('3', 'Test', '1001', 'gps', '2', 'gaurav', '2017-11-04 11:09:15', '23435', '1012', '112', '2002');
