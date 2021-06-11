package com.mercadolivre.bootcamp.services.impl;

import com.mercadolivre.bootcamp.dto.PropertyDTO;
import com.mercadolivre.bootcamp.dto.PropertyResponseDTO;
import com.mercadolivre.bootcamp.dto.RoomDTO;
import com.mercadolivre.bootcamp.enums.DistrictEnum;
import com.mercadolivre.bootcamp.services.CalculateService;

import java.util.ArrayList;
import java.util.List;

public class CalculateServiceImpl implements CalculateService {


    @Override
    public PropertyResponseDTO calculate(PropertyDTO propertyDTO) {
        PropertyResponseDTO propertyResponseDTO = new PropertyResponseDTO(propertyDTO);
        propertyResponseDTO.setSquareFeet(calculatePropertyTotalSquareFeet(propertyDTO));
        setBiggestRoom(propertyDTO, propertyResponseDTO);
        propertyResponseDTO.setPrice(calculatePropertyValue(propertyDTO));

        return propertyResponseDTO;
    }

    @Override
    public Double calculateRoomSquareFeet(RoomDTO roomDTO) {
        return roomDTO.getWidth() * roomDTO.getLength();
    }

    @Override
    public Double calculatePropertyTotalSquareFeet(PropertyDTO propertyDTO) {
        Double total = 0.0;
        List<RoomDTO> roomDTOList = new ArrayList<>(propertyDTO.getRooms());
        for (RoomDTO room: roomDTOList) {
            total+= calculateRoomSquareFeet(room);
        }
        return total;
    }

    @Override
    public void setBiggestRoom(PropertyDTO propertyDTO, PropertyResponseDTO propertyResponseDTO) {
        RoomDTO biggestRoom = null;
        Double sizeOfBiggestRoom = 0.0;
        Double roomAreaKeeper = 0.0;

        List<RoomDTO> listOfRooms = new ArrayList<>(propertyDTO.getRooms());
        for (RoomDTO room: listOfRooms) {
            roomAreaKeeper = calculateRoomSquareFeet(room);
           if(roomAreaKeeper > sizeOfBiggestRoom){
               biggestRoom = room;
               sizeOfBiggestRoom = roomAreaKeeper;
           }
        }
        propertyResponseDTO.setBiggest(biggestRoom);
    }

    @Override
    public Double calculatePropertyValue(PropertyDTO propertyDTO) {
        Double totalArea = 0.0;
        for (RoomDTO room: propertyDTO.getRooms()) {
            totalArea += calculateRoomSquareFeet(room);
        }
        return totalArea * DistrictEnum.getSquareFootValue(propertyDTO.getDistrict());
    }
}
