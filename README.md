# CRUDsteels
Java CRUD app with information about common steels used in manufacturing of plastics, tooling and knives/axes.

Will update readme as features are built out.
 As of 8/2/20

Endpoints: 
- /users
    - @Get /users - Lists all Users 
      - Works
    - @Post /user - add's new user
      - Returns 500
    - @Put /user/{userid} - updates full user (requires all user data points)
    - @Patch /user/{userid} - updates only fields sent
    - @Delete /user/{userid} - delete user at given id
    - @Get /getuserinfo - returns information about currently authenticated user
      -Currently Slightly Broken 
    
- /steels
    - @Get /steels - Lists all steels
    - @Get /steel/{steelid} - Lists steel at given ID #
    - @Get /name/{steelname} - lists steel with given name
    - @Get /name/like/{steelname} - 
        search for steel containing characters (ie "390" would return M390 & K390)
    - @Get /manufacturer/{mfrname} - list all by Manufacturer
    
    - @Post /steel - add's new steel to database
    - @Put /steel/{steelid} - updates full steel (requires all fields sent)
    - @Patch /steel/{steelid} - updates fields sent (doesn't require all fields)
    - @Delete /steel/{steelid} - deletes steel at given ID #
    

    
    
