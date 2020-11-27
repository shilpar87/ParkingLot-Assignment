# ParkingLot-Assignment

Create a Parking Lot Pricing service in Java or PHP that takes the Entry and Exit time of vehicle and returns total amount to be collected at the exit gate using the tariff table given below:-

Parking Duration	Weekend (Sat,Sun) Rate	Weekday Rate

< 2 hours 
	$5 	$7
>2 & <=5 hours 
	$8 	$10
>5 & <=10 hours 
	$12 	$15
>10 Hours & <=15 hours 
	$18 	$22
>15 hours & <=24 Hours 
	$25 	$30


•	The service should also maintain individual billing amounts collected at Exit gate for reporting purpose- The storage layer to store individual billing records does not need to be implemented, it can be mocked.
•	Implementation of Reporting service will also use the mocked storage layer. Please decide what functions you would like to expose for the reporting service.
•	All endpoints exposed by Service must be RESTful.
•	Demonstrate OO design, SOLID principles and use any framework you wish as long as you can justify its usage.
