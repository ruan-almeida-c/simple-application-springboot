package com.poc.clickbus.controllers;

import com.poc.clickbus.Api.ManagePlacesApi;
import com.poc.clickbus.model.Place;
import com.poc.clickbus.model.PlaceRequest;
import com.poc.clickbus.model.PlaceToUpdateRequest;
import com.poc.clickbus.model.SimpleResponse;
import com.poc.clickbus.services.PlaceService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ManagePlacesApiController implements ManagePlacesApi {

    @Resource
    private PlaceService placeService;

        @Override
    public ResponseEntity<String> createPlace(@RequestBody PlaceRequest place) {

        log.info("Starting the process of creating places.");

        placeService.create(place);

        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<String> deletePlace(@PathVariable Long id) {

        log.info("Starting the process of delete places.");

        placeService.delete(id);

        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<SimpleResponse> getPlace(@PathVariable Long id) {

        log.info("Starting the process of get places.");

        SimpleResponse simpleResponse = placeService.get(id);

        return new ResponseEntity<>(simpleResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updatePlace(@RequestBody PlaceToUpdateRequest place) {

        log.info("Starting the process of update places.");

        placeService.update(place);

        return ResponseEntity.ok(null);
    }
}
