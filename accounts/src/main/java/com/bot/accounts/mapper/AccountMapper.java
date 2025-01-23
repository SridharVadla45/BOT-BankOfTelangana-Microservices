package com.bot.accounts.mapper;

import com.bot.accounts.dto.AccountDto;
import com.bot.accounts.entity.Account;

public final class AccountMapper {

    private AccountMapper() {}

    public static AccountDto toDto(Account account) {
        if (account == null) {
            return null;
        }

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setAccountType(account.getAccountType());
        accountDto.setBalance(account.getBalance());
        accountDto.setCurrency(account.getCurrency());
        accountDto.setBranchAddress(account.getBranchAddress());

        return accountDto;
    }

    public static Account toEntity(AccountDto accountDto) {
        if (accountDto == null) return null;
        Account account = new Account();
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setCurrency(accountDto.getCurrency());
        account.setBalance(accountDto.getBalance());
        account.setAccountType(accountDto.getAccountType());
        account.setBranchAddress(accountDto.getBranchAddress());
        return account;
    }
}
