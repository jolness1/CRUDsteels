package com.example.crudsteels.controllers;

import com.example.crudsteels.models.Steels;
import com.example.crudsteels.services.SteelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/steels")
public class SteelsController
{
    @Autowired
    SteelService steelService;

    // HTTP GET

//    - @Get /steels - Lists all steels

    @GetMapping(value = "/steels", produces = {"application/json"})
    public ResponseEntity<?> listAllSteels(HttpServletRequest request)
    {
        List<Steels> mySteels = steelService.findAll();
        return new ResponseEntity<>(mySteels, HttpStatus.OK);
    }

//     - @Get /steel/{steelid} - Lists steel at given ID #


    @GetMapping(value = "/steel/{steelid}", produces = {"application/json"})
    public ResponseEntity<?> getSteelById (
            @PathVariable Long steelid)
    {
        Steels s = steelService.findSteelById(steelid);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

//    - @Get /name/{steelname} - lists steel with given name

    @GetMapping(value = "/name/{steelName}", produces = {"application/json"})
    public ResponseEntity<?> getSteelByName (
            @PathVariable String steelName)
    {
        Steels s = steelService.findByName(steelName);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

//    - @Get /name/like/{steelname} search for steel containing characters (ie "390" would return M390 & K390)

    @GetMapping(value = "/name/like/{steelName}", produces = {"application/json"})
    public ResponseEntity<?> getSteelLikeName (
            @PathVariable String steelName)
    {
        Steels s = steelService.findByNameContaining(steelName);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

//    - @Get /manufacturer/{mfrname} - list all by Manufacturer

    @GetMapping(value = "/manufacturer/{manufacturer}", produces = {"application/json"})
    public ResponseEntity<?> getSteelByManufacturer (
            @PathVariable String manufacturer)
    {
        Steels s = steelService.findByManufacturer(manufacturer);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    // HTTP POST

//    - @Post /steel - add's new steel to database

    @PostMapping(value = "/steel", consumes = {"application/json"})
    public ResponseEntity<?> addNewSteel(
            @Valid
            @RequestBody
            Steels newsteel) throws URISyntaxException
    {
        newsteel.setSteelid(0);
        newsteel = steelService.save(newsteel);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newSteelURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{steelid}")
                .buildAndExpand(newsteel.getSteelid())
                .toUri();
        responseHeaders.setLocation(newSteelURI);

        return new ResponseEntity<>(
                null,
                responseHeaders,
                HttpStatus.CREATED);
    }

    // HTTP PUT
//    - @Put /steel/{steelid} - updates full steel (requires all fields sent)

    @PutMapping(value = "/steel/{steelid}", consumes = "application/json")
    public ResponseEntity<?> updateFullSteel(
            @Valid
            @RequestBody
                Steels updateSteel,
            @PathVariable
                long steelid)
    {
        updateSteel.setSteelid(steelid);
        steelService.save(updateSteel);

        return new ResponseEntity<>(HttpStatus.OK);
    }

//    - @Patch /steel/{steelid} - updates fields sent (doesn't require all fields)

    @PatchMapping(value = "/steel/{steelid}", consumes = "application/json")
    public ResponseEntity<?> updateSteel(
            @RequestBody
                Steels updateSteel,
            @PathVariable
                long steelid)
    {
        steelService.update(updateSteel, steelid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


//    - @Delete /steel/{steelid} - deletes steel at given ID #

    @DeleteMapping(value = "/steel/{steelid}")
    public ResponseEntity<?> deleteSteelById(
            @PathVariable
                long steelid)
    {
        steelService.delete(steelid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
