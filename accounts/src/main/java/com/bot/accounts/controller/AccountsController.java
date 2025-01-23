package com.bot.accounts.controller;

import com.bot.accounts.dto.CustomerDto;
import com.bot.accounts.dto.ResponseDto;
import com.bot.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/api/accounts",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class AccountsController {

    private IAccountService accountService;


    @PostMapping("/create")
    public ResponseEntity<ResponseDto<Object>> createAccount(@RequestBody CustomerDto customerDto) {

        accountService.createAccountDetails(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ResponseDto.builder()
                        .message("Account created successfully")
                        .timeStamp(LocalDateTime.now())
                        .statusCode(HttpStatus.CREATED)
                        .build()
        );
    }


    @GetMapping("/{mobileNumber}")
    public ResponseEntity<ResponseDto<Object>> fetchAccount(@PathVariable String mobileNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(
            ResponseDto.builder().message(accountService.fetchAccountDetails(mobileNumber))
                    .timeStamp(LocalDateTime.now())
                    .statusCode(HttpStatus.OK).build()
        );
    }


    @PutMapping("/update")
    public ResponseEntity<ResponseDto<Object>> updateAccount(@RequestBody CustomerDto customerDto) {
        accountService.updateAccountDetails(customerDto);
        return ResponseEntity.status(HttpStatus.OK).body(
            ResponseDto.builder().message("Account updated successfully" + "with provided details "+customerDto.toString())
                    .timeStamp(LocalDateTime.now())
                    .statusCode(HttpStatus.OK).build()
        );
    }


    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto<Object>> deleteAccount(@RequestParam String mobileNumber) {
        accountService.deteleteAccountDetails(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(
            ResponseDto.builder().message("Account deleted successfully")
                    .timeStamp(LocalDateTime.now())
                    .statusCode(HttpStatus.OK).build()
        );
    }

}
