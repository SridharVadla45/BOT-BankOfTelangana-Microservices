package com.bot.accounts.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private Long accountNumber;

    private String accountType;

    private double balance;

    private String currency;

    private String branchAddress;


}
