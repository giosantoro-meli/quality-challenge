package com.mercadolivre.bootcamp.services;

import com.mercadolivre.bootcamp.dto.PropertyDTO;
import com.mercadolivre.bootcamp.dto.PropertyResponseDTO;
import com.mercadolivre.bootcamp.dto.RoomDTO;

public interface CalculateService {

    public PropertyResponseDTO calculate(PropertyDTO propertyDTO);

    public Double calculateRoomSquareFeet(RoomDTO roomDTO);

    public Double calculatePropertyTotalSquareFeet(PropertyDTO propertyDTO);

    public void setBiggestRoom(PropertyDTO propertyDTO, PropertyResponseDTO propertyResponseDTO);

    public Double calculatePropertyValue(PropertyDTO propertyDTO);
}
