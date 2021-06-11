package com.mercadolivre.bootcamp.resources;

import com.mercadolivre.bootcamp.dto.PropertyDTO;
import com.mercadolivre.bootcamp.dto.PropertyResponseDTO;
import com.mercadolivre.bootcamp.services.CalculateService;
import com.mercadolivre.bootcamp.services.impl.CalculateServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateController {

    CalculateService service = new CalculateServiceImpl();

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public ResponseEntity<PropertyResponseDTO> calculate(@RequestBody PropertyDTO propertyDTO){

        PropertyResponseDTO responseDTO = service.calculate(propertyDTO);

        return ResponseEntity.ok(responseDTO);
    }
}
