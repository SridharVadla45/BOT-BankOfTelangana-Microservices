package com.bot.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
@Schema(name = "Response",description = "Response details ")
public class ResponseDto<T> {
    @Schema(description = "Response message description",example = "Account  created successfully ")
    private T message;
    @Schema(description = "Htpp status code for response ",example = "CREATED")
    private HttpStatusCode statusCode;
    @Schema(description = "timestamp of response ")
    private LocalDateTime timeStamp;
}
