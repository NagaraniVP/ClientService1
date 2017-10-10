# ClientService1
Acts as Discoveryclient1 which interacts with another service through Eureka service registry using @FeignClient to get Data from DB using Spring Data JPA and fetching properties from cloud config server.

RestControllerTest.java----Controller

Spring.Application.name: test-client1
server.port: 8071 - localhost
profile: default

    
 /**
     * Mapping URLs to get User data from Client2 & DB using @Feignclient from Client1
     * @return
     */
     
   "/feign/client2/save"          -- Stores User Data into DB  
        Ex: User Data  //Where projectName property will be taken from cloud
            {"username": "user1"
             }

   "/feign/client2/all"           --To fetch all user data from DB

   "/feign/client2/byName/{name}" -- To fetch User data by UserName from DB

   
