package com.bot.accounts.controller;

import com.bot.accounts.dto.CustomerDto;
import com.bot.accounts.dto.ErrorResponseDto;
import com.bot.accounts.dto.ResponseDto;
import com.bot.accounts.service.IAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Tag(
        name = "Accounts Service - Rest Api Endpoints",
        description = "Rest Api endpoints related to Accounst Microservice of Bank of Telangana Application"
)
@RestController
@RequestMapping(path = "/api/accounts",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated
public class AccountsController {

    private IAccountService accountService;


    @Operation(
            description = "Endpoint for creating  accounts"
    )
    @ApiResponses(
            {@ApiResponse(
                responseCode = "201",
                description = "CREATED"
        ),
            @ApiResponse(
                    responseCode = "400",
                    description = "BAD_REQUEST",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )}
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto<Object>> createAccount(@Valid @RequestBody CustomerDto customerDto) {

        accountService.createAccountDetails(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ResponseDto.builder()
                        .message("Account created successfully")
                        .timeStamp(LocalDateTime.now())
                        .statusCode(HttpStatus.CREATED)
                        .build()
        );
    }

    @Operation(
            description = "Endpoint for fetching  accounts details "
    )
    @ApiResponses(
            {@ApiResponse(
                    responseCode = "200",
                    description = "SUCCESS"
            ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "BAD_REQUEST",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorResponseDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "NOT_FOUND",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorResponseDto.class)
                            )
                    )
            }
    )
    @GetMapping("/{mobileNumber}")
    public ResponseEntity<ResponseDto<Object>> fetchAccount(@PathVariable
                                                                @Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number")
                                                                String mobileNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(
            ResponseDto.builder().message(accountService.fetchAccountDetails(mobileNumber))
                    .timeStamp(LocalDateTime.now())
                    .statusCode(HttpStatus.OK).build()
        );
    }

    @Operation(
            description = "Endpoint for updating   accounts details "
    )
    @PutMapping("/update")
    public ResponseEntity<ResponseDto<Object>> updateAccount(@Valid @RequestBody CustomerDto customerDto) {
        accountService.updateAccountDetails(customerDto);
        return ResponseEntity.status(HttpStatus.OK).body(
            ResponseDto.builder().message("Account updated successfully" + "with provided details "+customerDto.toString())
                    .timeStamp(LocalDateTime.now())
                    .statusCode(HttpStatus.OK).build()
        );
    }

    @Operation(
            description = "Endpoint for deleting  accounts details "
    )

    @DeleteMapping("/delete")
    @ApiResponses(
            {@ApiResponse(
                    responseCode = "200",
                    description = "SUCCESS"
            ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "NOT_FOUND",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorResponseDto.class)
                            )
                    )
            }
    )
    public ResponseEntity<ResponseDto<Object>> deleteAccount(@RequestParam
                                                                 @Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number")
                                                                 String mobileNumber) {
        accountService.deteleteAccountDetails(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(
            ResponseDto.builder().message("Account deleted successfully")
                    .timeStamp(LocalDateTime.now())
                    .statusCode(HttpStatus.OK).build()
        );
    }

}
