package com.bot.accounts.service;


import com.bot.accounts.dto.CustomerDto;

public interface IAccountService {

    void createAccountDetails(CustomerDto customerDto);

    CustomerDto fetchAccountDetails(String mobileNumber);

    void updateAccountDetails(CustomerDto customerDto);

    void deteleteAccountDetails(String mobileNumber);




}
