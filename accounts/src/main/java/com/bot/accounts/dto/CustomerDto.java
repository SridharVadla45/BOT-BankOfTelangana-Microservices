package com.bot.accounts.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDto {

    private String name ;


    private String email ;


    private String mobileNumber;

    private AccountDto accountDto;

}
