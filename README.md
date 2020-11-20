 

I have used Eureka Server for Discovery and Zuul-Proxy as API Gate way and have written User-service with two end points.


1.)	Project Setup:
1.	Clone the repository from GitHub
 https://github.com/sarfrazgithub/ING-CodeChallenge.git 

2.	Go to the folder ING-CodeChallenge/eureka-server and open command prompt and start the service using below command.
Command:  mvn spring-boot:run 
Verify in the browser: http://localhost:8761/

3.	Go to the folder ING-CodeChallenge/api-gateway and open command prompt and start the service using below command.
Command:  mvn spring-boot:run 

4.	Go to the folder ING-CodeChallenge/user-service and open command prompt and start the service using below command.
Command:  mvn test spring-boot:run 


2.) Testing the application:
1.)	Token Generation
First you need to generate a token for authentication. We have two endpoints. One for fetching and another one for updating.  Pass userRole as admin (case sensitive) for access update operation. Another other role passed will give read-only access to view. 
URL: http://localhost:8080/api/token/generate
Method: POST
Payload: {
   "userId":1,
   "userRole":"admin"    
}
 
 
You will get token in response. 
 
Append it to header in as shown below. 
Key is Authorization
Value is Bearer +”TOKEN_GENERATED”

 

This will authenticate and authoise end points based on the userRole. This tokens are valid for 10 minutes. Post that you should generate new token.  If you are passing wrong token or no token you will below errors.

 
              
2.)	Fetch User Functionality:
                    End-point: http://localhost:8080/api/fetchuser/101
                    Method: GET                
               User role :  anything.  Since fetchuser is read only , you can pass any user role while generating token.

  Sample output:  
    As part of start up, users with user id 101,102,103,104,105 are inserted. Use this for testing.
  Valid user:
 
User id not in DB:
 

Passing non-numeric user id:

 

3.)	Update user functionality:
               End-point: http://localhost:8080/api/updateuser/101
                      Method: PUT                
                      User role :  admin.  Since update can be done by admin, make sure you pass correct information while generating token
                        Payload:  

{
    "title": "Mr.",
    "firstname": "Steve",
    "lastname": "Waugh",
    "gender": "M",
    "address": {
        "street": "502 Turcotte Dale",
        "city": "Sydney",
        "state": "NSW",
        "postcode": 2000
    }
}

    Sample output:  
    As part of start up, users with user id 101,102,103,104,105 are inserted. Use this for testing.
  Valid UPDATE:
You will get the updated record in response
          
Updating any field : 

Updating any field in address:
     

Passing userid not in DB:
 

Passing not numeric User Id:
 
NON-admin trying to update:
 

4.)	Other testing:
All the authorisation of token and user roles are done at api-gateway. This may lead to security issue if the endpoint of user-service is known. We are running the application of user service in localhost:8090. If anyone sending request to this address, we are validating whether the header contains key “Authorization”. We are not again validating the actual token.  I have kept like this for coding challenge. In ideal situation I will validate the token again. For now I am validating, is any token present alone.

 


5.)	Circuit breaker testing: 
If the user-service not available, I am falling back in api-gateway and show that service is not available alone. For this testing, terminate the user-service.
 



Apart from this, I have provided entry and exit logging in api-gateway using zuul pre and post filters. In user-service,  I have used AOP for logging and exception handling. I have also written unit and integrated testing for user-service.
