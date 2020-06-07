# My Ekart application

This assignment is build on
- micro-service architecture 
- using spring boot
- Gradle as build tool
- Flyway as db migration tool
- Mysql as db
- Fiegn as rest client
- Zuul as api-gateway request router as well as load balancer


There are 4 services and 2 utility repositories, namely
- **Services**
	- my-ekart-api-gateway : Entry point to the application and this service is responsible for request routing to respective services.
	- my-ekart-admin-service:  All user management operation happens here.
	- my-ekart-item-inventory-service: All inventory management happens here.
	- my-ekart-order-service: All order management performed here
- **Utilities**
	- my-ekart-messaging: All request and responses are kept here which will be visible to all service
	- my-ekart-utlities: Common utility files are kept here such as base class, configuration class etc.
	
	
A postman collection is added for all end-points.