package com.mercadolivre.bootcamp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ControllerAdvice
public class CalculateExceptionControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<?> handleConflict(MethodArgumentNotValidException e, HttpServletRequest httpServletRequest){
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        List<ErrorDetail> errorDetailList = fieldErrors
                .stream().map(fe -> new ErrorDetail(fe.getDefaultMessage(), fe.getField(), Objects.requireNonNull(fe.getRejectedValue()).toString()))
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(errorDetailList);
    }

    @ExceptionHandler(DistrictException.class)
    public ResponseEntity<?> handleConflict(DistrictException d, HttpServletRequest httpServletRequest){
        return ResponseEntity.badRequest().body("Non existent district or mistyped district name");
    }
}
