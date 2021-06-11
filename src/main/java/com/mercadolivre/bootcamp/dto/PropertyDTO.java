package com.mercadolivre.bootcamp.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class PropertyDTO {

    @NotBlank(message = "Property name cannot be empty")
    @Size(max = 30, message = "Property name size must not exceed 30 characters")
    @Pattern(regexp = "^([A-Z]+)([a-z]|[A-Z]|[0-9]|\\s)+", message = "Property name must start with a uppercase letter")
    private String name;

    @NotBlank(message = "Property name cannot be empty")
    @Size(max = 45, message = "Property name size must not exceed 45 characters")
    private String district;

    @Valid
    @NotEmpty(message = "There must be at least one room")
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
