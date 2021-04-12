
# Property management system

A simple POC for Property management for property buyers.

## Description

It is an POC created by keeping an assumption of SpeedHome in initial stage.

## Getting Started

### Dependencies

* JDK 8.0
* Spring 2.4.4
* HR in-memory database
* Maven 3.6.3

### Installing

* Download the source code from repository and unpack the zip file. 
* Build the project by running maven command 'mvn clean install' from corresponding directory.
* Run the project using maven command 'mvn spring-boot:run' from same directory.

### Executing program

* A sample key(4F6D83MH53) is provided in the project to be used via postman.
![alt text](https://github.com/stasim101/property_management_api/blob/main/image/Entering_API_Key.jpg)
* Test the creation functionality and note the property id mentioned as response in postman.
![alt text](https://github.com/stasim101/property_management_api/blob/main/image/Create.jpg)
* Test the updating functionality, by selecting patch request and changing the address in JSON.
![alt text](https://github.com/stasim101/property_management_api/blob/main/image/Update.jpg)
* Test the approve functionality, by clear the JSON fom body. By sending id, it approves the property.
![alt text](https://github.com/stasim101/property_management_api/blob/main/image/Approve.jpg)
* Test the search functionality, by sending GET request.
![alt text](https://github.com/stasim101/property_management_api/blob/main/image/Search.jpg)
* Additional functionality to create API Key is added. You can have a look on.
![alt text](https://github.com/stasim101/property_management_api/blob/main/image/GenerateAPI.jpg)


## Authors
stasim101@gmail.com
