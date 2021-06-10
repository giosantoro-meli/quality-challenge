package com.mercadolivre.bootcamp.dto;

public class PropertyResponseDTO extends PropertyDTO{
    private Double squareFeet;
    private Double price;
    private RoomDTO biggest;

    public PropertyResponseDTO() {
    }

    public PropertyResponseDTO(PropertyDTO propertyDTO){
        this.setName(propertyDTO.getName());
        this.setDistrict(propertyDTO.getDistrict());
        this.setRooms(propertyDTO.getRooms());
    }

    public Double getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(Double squareFeet) {
        this.squareFeet = squareFeet;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public RoomDTO getBiggest() {
        return biggest;
    }

    public void setBiggest(RoomDTO biggest) {
        this.biggest = biggest;
    }
}
