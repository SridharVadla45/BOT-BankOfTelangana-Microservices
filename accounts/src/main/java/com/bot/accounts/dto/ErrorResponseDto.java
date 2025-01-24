package com.bot.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "ErrorResponse")
public class ErrorResponseDto {
    private String message;
    private HttpStatusCode errorCode;
    private String apiPath;
    private LocalDateTime timeStamp;
}
