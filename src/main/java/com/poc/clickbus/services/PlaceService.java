package com.poc.clickbus.services;

import com.poc.clickbus.model.PlaceRequest;
import com.poc.clickbus.model.PlaceToUpdateRequest;
import com.poc.clickbus.model.SimpleResponse;

public interface PlaceService {

    public void create(PlaceRequest placeRequest);
    public void delete(Long id);
    public void update(PlaceToUpdateRequest placeRequest);
    public SimpleResponse get(Long id);
}
