package com.bot.accounts.dto;

import lombok.*;

import java.util.HashMap;


@Getter
@Setter
@ToString
public class ValidationResponseDto {
    private HashMap<String,String> validationException;

    public ValidationResponseDto(HashMap<String,String> validationException) {
        this.validationException = validationException;
    }
}

