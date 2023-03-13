package com.poc.clickbus.services;

import com.poc.clickbus.model.*;
import com.poc.clickbus.repository.ManagePlacesRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PlaceServiceImpl implements PlaceService{

    @Resource
    private ManagePlacesRepository managePlacesRepository;

    @Override
    public void create(PlaceRequest placeRequest) {

        Place newPlace = new Place(placeRequest.name(), placeRequest.slug(), placeRequest.city(), placeRequest.state());

        managePlacesRepository.save(newPlace);
    }

    @Override
    public void delete(Long id) {

        try {
            managePlacesRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(PlaceToUpdateRequest placeRequest) {
        Optional<Place> oldPlaceInformation;
        try {
            oldPlaceInformation = managePlacesRepository.findById(placeRequest.id());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(oldPlaceInformation.isPresent()){

            Place temp = oldPlaceInformation.get();
            temp.setName(placeRequest.name());
            temp.setSlug(placeRequest.slug());
            temp.setCity(placeRequest.city());
            temp.setState(placeRequest.state());

            managePlacesRepository.save(temp);
        }

    }

    @Override
    public SimpleResponse get(Long id) {
        Optional<Place> oldPlaceInformation;
        try {
            oldPlaceInformation = managePlacesRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        SimpleResponse simpleResponse;

        if (oldPlaceInformation.isPresent()){

            simpleResponse = new SimpleResponse(new SimpleDataResponse("Place located successfully.", UUID.randomUUID().toString(), oldPlaceInformation.get()));
        }else {

            simpleResponse = new SimpleResponse(new SimpleDataResponse("We couldn't find a place with the provided ID.", UUID.randomUUID().toString(), null));
        }

        return simpleResponse;

    }
}