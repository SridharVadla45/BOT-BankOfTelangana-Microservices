package com.bot.accounts.exception;

import com.bot.accounts.dto.ErrorResponseDto;
import com.bot.accounts.dto.ValidationResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        HashMap<String,String > validationErrors = new HashMap<>();
            ex.getBindingResult().getAllErrors().forEach(error -> {
                String fieldName =  error.getCodes()[1].toString();
                String errorMessage = error.getDefaultMessage();
                validationErrors.put(fieldName,errorMessage);

            });
        ValidationResponseDto validationResponseDto = new ValidationResponseDto(validationErrors);
        return new ResponseEntity<>(validationResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException exception, HttpServletRequest request) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                exception.getMessage(),
                HttpStatus.NOT_FOUND,
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException exception,HttpServletRequest request) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST,
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleExceptions(Exception exception,HttpServletRequest request) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
