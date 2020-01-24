The app was built with Spring boot and Java. The feature of the app is exposed through a JSON REST API.


# Getting Started

Before moving further, we need a .jar file. 
Run the `mvn clean install` command to make sure that it's generated.

Move to the root directory of the application and run this command:

`$ docker build -t spo-app `

And finally, let's run our image:

`$ docker run -p 8090:8080 spo-app` 


## Main url for spo api (POST)
http://locahost:8080/api/spo

You can also the Swagger UI endpoint from:
http://localhost:8080/swagger-ui.html


####Example

* Request
	```json 
	{ 
		"rooms": [24, 28],
		"senior": 11, 
		"junior": 6 
	 }
	 ```
	
* Response (success)
	```json 
		[
            {
                "senior": 2,
                "junior": 1
            },
            {
                "senior": 2,
                "junior": 1
            }
        ]
     ```
* Response (validation error)
	```json 
		{
            "timestamp": "2020-01-24T14:35:05.598+0000",
            "status": 400,
            "error": "Bad Request",
     ```
 

# Algorithm
The optimisation is implemented in the `GreedyOptimiseStaffsImpl` class.
At first, we calculate how many senior staff need. Then, we recursively call the `optimiseStructureCapacity` method by
 decrease seniorsCount and increase juniorCount,
  until it finds best solution. 
  We want to minimize difference between staffs' capacity and size of the building.