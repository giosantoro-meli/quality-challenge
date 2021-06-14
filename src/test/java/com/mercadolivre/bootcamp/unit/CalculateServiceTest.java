package com.mercadolivre.bootcamp.unit;

import com.mercadolivre.bootcamp.dto.PropertyDTO;
import com.mercadolivre.bootcamp.dto.PropertyResponseDTO;
import com.mercadolivre.bootcamp.dto.RoomDTO;
import com.mercadolivre.bootcamp.services.CalculateService;
import com.mercadolivre.bootcamp.services.impl.CalculateServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculateServiceTest {

    CalculateService calculateService = new CalculateServiceImpl();
    List<RoomDTO> roomDTOList = new ArrayList<>();
    PropertyDTO propertyDTO;

    @BeforeEach
    public void setup(){
        roomDTOList.add(new RoomDTO("Dormitorio principal", 5.0, 4.0));
        roomDTOList.add(new RoomDTO("Dormitorio secundario", 3.5, 3.0));
        roomDTOList.add(new RoomDTO("Sala dois ambientes", 8.0, 4.0));
        roomDTOList.add(new RoomDTO("Banheiro suite", 2.5, 1.8));
        roomDTOList.add(new RoomDTO("Banheiro corredor", 2.0, 2.0));
        roomDTOList.add(new RoomDTO("Cozinha", 4.5, 1.8));
        roomDTOList.add(new RoomDTO("Varanda", 3.5, 2.2));

        propertyDTO = new PropertyDTO("Apartamento 2 dorms", "Santana");
        propertyDTO.setRooms(roomDTOList);
    }

    @Test
    void calculateRoomSquareFeetTest() {
        Double result = calculateService.calculateRoomSquareFeet(roomDTOList.get(0));
        assertEquals(20.0, result);
    }

    @Test
    void calculatePropertyTotalSquareFeetTest() {
        Double result = calculateService.calculatePropertyTotalSquareFeet(propertyDTO);
        assertEquals(86.8, result);
    }

    @Test
    void setBiggestRoomTest() {
        PropertyResponseDTO propertyResponseDTO = new PropertyResponseDTO();
        calculateService.setBiggestRoom(propertyDTO, propertyResponseDTO);
        assertEquals(propertyDTO.getRooms().get(2), propertyResponseDTO.getBiggest());
    }

    @Test
    void calculatePropertyValueTest() {
        Double result = calculateService.calculatePropertyValue(propertyDTO);
        assertEquals(450492.0, result);
    }
}