
use LocationTracking;



DROP TABLE IF EXISTS `tracking_Device`;
CREATE TABLE `tracking_Device` (
  `device_id` int(11) NOT NULL AUTO_INCREMENT,
  `device_type` varchar(10) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`device_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS tracking_Detail;
CREATE TABLE `LocationTracking`.`tracking_Detail` (
  `tracking_id` INT NOT NULL,
  `device_id` INT NOT NULL,
  `latitude` DECIMAL(10,6) NOT NULL,
  `longitude` DECIMAL(10,6) NOT NULL,
  `speed` INT(3) NOT NULL,
  `driver_id` INT NOT NULL,
  `additionalInfo` VARCHAR(45) NULL,
  `eventtime` TIMESTAMP NOT NULL,
  PRIMARY KEY (`tracking_id`),
  INDEX `fk_tracking_deviceId_idx` (`device_id` ASC),
  CONSTRAINT `fk_tracking_deviceId`
    FOREIGN KEY (`device_id`)
    REFERENCES `LocationTracking`.`tracking_Device` (`device_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

DROP TABLE IF EXISTS current_Location;

CREATE TABLE `LocationTracking`.`current_Location` (
  `driver_id` INT NOT NULL,
  `mobileno` INT NOT NULL,
  `latitude` DECIMAL(10,6) NOT NULL,
  `longitude` DECIMAL(10,6) NOT NULL,
  `speed` INT(3) NOT NULL,
  `device_id` INT(11) NOT NULL,
  `additionalInfo` VARCHAR(45) NULL,
  `eventtime` TIMESTAMP NOT NULL,
  PRIMARY KEY (`driver_id`, `mobileno`),
  INDEX `fk_driver_1_idx` (`device_id` ASC),
  CONSTRAINT `fk_driver_1`
    FOREIGN KEY (`device_id`)
    REFERENCES `LocationTracking`.`tracking_Device` (`device_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


