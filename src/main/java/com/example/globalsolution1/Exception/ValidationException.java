package com.example.globalsolution1.Exception;

import com.example.globalsolution1.DTO.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ValidationException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String erroGeral = "Sua Requisição não pode ser realizada";
        Map<String, String> motivos = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                motivos.put(error.getField(), error.getDefaultMessage())
        );

        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(erroGeral, motivos);
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
