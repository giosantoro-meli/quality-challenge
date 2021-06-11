package com.mercadolivre.bootcamp.enums;

import com.mercadolivre.bootcamp.exceptions.DistrictException;

import java.util.Arrays;

public enum DistrictEnum {

    BUTANTA(7186.00),
    JABAQUARA(7866.00),
    JARDINS(10010.00),
    MOEMA(8100.00),
    MOOCA(4790.00),
    PINHEIROS(9000.00),
    SANTANA(5190.00),
    TATUAPE(4960.00),
    TUCURUVI(6283.00);

    private final Double squareFootValue;

    DistrictEnum(Double squareFootValue){
        this.squareFootValue = squareFootValue;
    }

    public Double getSquareFootValue() {
        return squareFootValue;
    }

    public static Double getSquareFootValue(String districtName){
        return Arrays.stream(DistrictEnum.values())
                .filter(districtEnum -> districtEnum.toString().equalsIgnoreCase(districtName))
                .findFirst().orElseThrow(DistrictException::new).getSquareFootValue();
    }
}
