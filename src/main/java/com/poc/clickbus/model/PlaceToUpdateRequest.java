package com.poc.clickbus.model;

public record PlaceToUpdateRequest(Long id, String name, String slug, String city, String state) {
}
