package com.example.spring.common;

import com.example.spring.model.RespBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BadRequestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult result = ex.getBindingResult();
        if (result.hasFieldErrors()) {
            FieldError fieldError = result.getFieldError();
            System.out.println(fieldError.getField() + ": " + fieldError.getDefaultMessage());
            RespBean respBean = new RespBean(400,fieldError.getField() + ": " + fieldError.getDefaultMessage(),null);
            return ResponseEntity.badRequest().body(respBean);
        }
        return super.handleBindException(ex, headers, status, request);
    }
}