package com.poc.clickbus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleDataResponse{

    private String message;
    private String transaction;
    private Place place;

}
