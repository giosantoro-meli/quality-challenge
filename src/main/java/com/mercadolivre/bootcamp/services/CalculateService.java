package com.mercadolivre.bootcamp.services;

import com.mercadolivre.bootcamp.dto.PropertyDTO;
import com.mercadolivre.bootcamp.dto.PropertyResponseDTO;
import com.mercadolivre.bootcamp.dto.RoomDTO;

public interface CalculateService {

    PropertyResponseDTO calculate(PropertyDTO propertyDTO);

    Double calculateRoomSquareFeet(RoomDTO roomDTO);

    Double calculatePropertyTotalSquareFeet(PropertyDTO propertyDTO);

    void setBiggestRoom(PropertyDTO propertyDTO, PropertyResponseDTO propertyResponseDTO);

    Double calculatePropertyValue(PropertyDTO propertyDTO);
}
