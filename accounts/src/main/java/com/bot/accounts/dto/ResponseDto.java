package com.bot.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ResponseDto<T> {

    private T message;
    private HttpStatusCode statusCode;
    private LocalDateTime timeStamp;
}
