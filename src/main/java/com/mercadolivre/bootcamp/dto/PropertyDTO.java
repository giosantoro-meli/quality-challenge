package com.mercadolivre.bootcamp.dto;

import java.util.ArrayList;
import java.util.List;

public class PropertyDTO {
    private String name;
    private String district;
    private List<RoomDTO> rooms = new ArrayList<>();

    public PropertyDTO() {}

    public PropertyDTO(String name, String district) {
        this.name = name;
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public List<RoomDTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDTO> rooms) {
        this.rooms = rooms;
    }
}
