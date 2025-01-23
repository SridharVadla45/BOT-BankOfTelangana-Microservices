package com.bot.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class ErrorResponseDto {
    private String message;
    private HttpStatusCode errorCode;
    private String apiPath;
    private LocalDateTime timeStamp;
}
