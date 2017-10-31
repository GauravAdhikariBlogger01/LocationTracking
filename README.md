## Setup
-  Mysql 5.7
-  java 1.8
-  eclipse IDE
-  maven


##Build Instruction

-Navigate to project directory through command prompt
-mvn clean install
-mvn spring-boot : run


##Accessing web service


-http://localhost:8084 , Home page(jsp)


post request
-http://localhost:8084/add

{
 "deviceId":"1",
  "latitude":"1",
  "longitude":"2",
  "speed":"20",
  "additionalInfo":"test"
}

get request
-http://localhost:8084/getCall/{pass deviceid}

get request
-http://localhost:8084/getCall/{starttime}/{enddate}


## WebService Access for Scenario 2

Post

-http://localhost:8084/addDriverDevice/

Data set

{ 
 "deviceId":"2",
  "latitude":"1",
  "longitude":"2",
  "speed":"20",
  "mobileNumber":"123456",
  "driver_id":"1",
  "additionalInfo":"test"
}



