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


-http://localhost:8084 , Home page(jsp)


post request
-http://localhost:8084/addTrackRecord

{
 
 "deviceId":"2",
  "latitude":"10",
  "longitude":"8",
  "speed":"20",
  "mobileNumber":"123489",
  "driverId":"2",
  "additionalInfo":"test info"
}

get request
-http://localhost:8084/getTrackRecord/{pass deviceid}

get request
-http://localhost:8084/getTrackRecord/{starttime}/{enddate}


##WebService for get call

Get

-/getTrackRecord/{starttime}/{endtime}

-/getTrackRecord/{deviceid}

-/getTrackRecord/{starttime}/{endtime}/{deviceId}

-/getTrackRecord/{starttime}/{endtime}/{deviceId}/{driverId}


Post

-http://localhost:8084/addDriverDevice/

Data set

{
 
 "deviceId":"2",
  "latitude":"09",
  "longitude":"80",
  "speed":"20",
  "mobileNumber":"123489",
  "driverId":"2",
  "additionalInfo":"test"
}


