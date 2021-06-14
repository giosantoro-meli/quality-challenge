package com.mercadolivre.bootcamp.dto;

import javax.validation.constraints.*;

public class RoomDTO {

    @NotBlank(message = "Room name cannot be empty")
    @Size(max = 30, message = "Room name size must not exceed 30 characters")
    @Pattern(regexp = "^([A-Z]+)([a-z]|[A-Z]|[0-9]|\\s)+", message = "Room name must start with a uppercase letter")
    private String name;

    @NotNull(message = "Room width cannot be empty")
    @Positive
    @Max(value = 25, message = "Room width cannot be longer than 25m")
    private Double width;

    @NotNull(message = "Room length cannot be empty")
    @Positive
    @Max(value = 33, message = "Room width cannot be longer than 33m")
    private Double length;

    public RoomDTO() {
    }

    public RoomDTO(String name, Double width, Double length) {
        this.name = name;
        this.width = width;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }
}
