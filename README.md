# CRUDsteels
Java CRUD app with information about common steels used in manufacturing of plastics, tooling and knives/axes.

Will update readme as features are built out.
 As of 8/2/20

Endpoints: 
- /users
    - @Get /users - Lists all Users 
      - Works
    - @Post /user - add's new user
      - Works, returns 201, takes in JSON obj in format like :
      - {
        "username": "admin1",
        "useremail": "admin1@admin.admin",
        "password" : "password",
        "roles": [
        {
        "role": {
        "roleid": 0,
        "name": "ADMIN"
        }
        }
        ]
        }
      ----------------------------
    - @Put /user/{userid} - updates full user (requires all user data points)
      - Returns 500 Error, appears related to the auditing fields not being included in request.
      
    - @Patch /user/{userid} - updates only fields sent
      - Returns 200, takes in JSON obj with any fields wanting to be updated (can do multiple fields at once)
        - {
          "username": "adminupdate"
          }
    - @Delete /user/{userid} - delete user at given id
      - Returns 200 but doesn't actually delete, going to investigate delete method
      
    - @Get /getuserinfo - returns information about currently authenticated user
      - Returns 500 and Res Not Found exception in console, appears to be the method
    
- /steels
    - @Get /steels - Lists all steels
      - Returns 200 and Full list of all items in SteelDB
      
    - @Get /steel/{steelid} - Lists steel at given ID #
      - Returns 200 and steel at given ID number

    - @Get /name/{steelname} - lists steel with given name
      - Working, returns JSON and 200
        
    - @Get /name/like/{steelname} - FINDALLCONTAINING
        search for steel containing characters (ie "390" would return M390 & K390)
    - Returns 200 and data 
    - Works except:
    - Searching 390 with m390/k390 in database gives a 
  "query did not return a unique result: 2; nested exception is javax.persistence.NonUniqueResultException:" error
    - Returns 200 and blank response with a non valid query (nothing contains that character) 
      - ie: search for "D" when no names contain that char and it returns 200 but nothing else
  
    - @Get /manufacturer/{mfrname} - list all by Manufacturer
      - Gives 500 and resource not found exception
        - only one mfr in db right now and has non alpha chars in it ( "-" ), 
          - wondering if that is due to .toLowerCase again
    
    - @Post /steel - add's new steel to database
    - @Put /steel/{steelid} - updates full steel (requires all fields sent)
    - @Patch /steel/{steelid} - updates fields sent (doesn't require all fields)
    - @Delete /steel/{steelid} - deletes steel at given ID #
    

    
    
