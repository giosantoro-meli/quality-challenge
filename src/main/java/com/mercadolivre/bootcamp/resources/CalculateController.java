package com.mercadolivre.bootcamp.resources;

import com.mercadolivre.bootcamp.dto.PropertyDTO;
import com.mercadolivre.bootcamp.dto.PropertyResponseDTO;
import com.mercadolivre.bootcamp.services.CalculateService;
import com.mercadolivre.bootcamp.services.impl.CalculateServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CalculateController {

    CalculateService service = new CalculateServiceImpl();

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public ResponseEntity<PropertyResponseDTO> calculate(@Valid @RequestBody PropertyDTO propertyDTO){

        PropertyResponseDTO responseDTO = service.calculate(propertyDTO);

        return ResponseEntity.ok(responseDTO);
    }
}
