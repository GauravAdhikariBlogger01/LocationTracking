
INSERT into `LocationTracking`.`tracking_device` (`device_id`, `device_type`, `description`) 
VALUES ('1', 'GPS', 'test');

INSERT into `LocationTracking`.`tracking_device` (`device_id`, `device_type`, `description`) 
VALUES ('2', 'Mobile', 'test');
    
INSERT INTO `LocationTracking`.`current_location` 
(`driver_id`, `mobileno`, `additionalinfo`, `device_id`, `latitude`, `longitude`, `speed`, `eventtime`)
VALUES ('100', '1234567890', 'test', '1', '11.00', '12.00001', '24', '2017-11-03 15:05:39');

INSERT INTO `LocationTracking`.`current_location` 
(`driver_id`, `mobileno`, `additionalinfo`, `device_id`, `latitude`, `longitude`, `speed`, `eventtime`)
VALUES ('101', '1234567899', 'test', '2', '11.00', '12.00001', '24', '2017-11-03 15:05:39');

