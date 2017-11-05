## Setup
-  Mysql 5.7
-  java 1.8
-  eclipse IDE
-  maven


##Build Instruction

-Navigate to project directory through command prompt
-mvn clean install
-mvn spring-boot : run


## WebService API  

#UI welcome page
-http://localhost:8084 , Home page(jsp)

##Get tracking details of any device on basis of driverId,deviceId between a time slot.

#Get

-http://localhost:8084/getTrackRecord/{starttime}/{endtime}/{deviceId}/{driverId}

#For example:

-http://localhost:8084/getTrackRecord/2012-02-01 00:00:00/2018-10-31 06:54:58/1001/2
Post


#Driver vehicle registration-POST Call
http://localhost:8084/registration

#For Example

Body:

{
 
 "driverName":"perwez",
  "mobileNumber":"1110011122",
  "vehicleId":"2002",
  "status":"true"
  
}


#Tracking Details send by any device-POST Call

http://localhost:8084/addTrackRecord

#For Example

Body:
{
 
 "assetId":"1001",
  "latitude":"2345",
  "longitude":"101",
  "speed":"112",
  "additionalInfo":"Test",
  "deviceType":"gps"
  
}



