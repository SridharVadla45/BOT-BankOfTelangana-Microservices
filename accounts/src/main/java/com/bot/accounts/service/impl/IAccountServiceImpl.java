package com.bot.accounts.service.impl;

import com.bot.accounts.constant.AccountConstants;
import com.bot.accounts.dto.CustomerDto;
import com.bot.accounts.entity.Account;
import com.bot.accounts.entity.Customer;
import com.bot.accounts.exception.CustomerAlreadyExistsException;
import com.bot.accounts.exception.ResourceNotFoundException;
import com.bot.accounts.mapper.AccountMapper;
import com.bot.accounts.mapper.CustomerMapper;
import com.bot.accounts.repository.AccountsRepository;
import com.bot.accounts.repository.CustomerRepository;
import com.bot.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IAccountServiceImpl implements IAccountService {

    private CustomerRepository customerRepository;
    private AccountsRepository accountsRepository;

    @Override
    public void createAccountDetails(CustomerDto customerDto) {
        Optional<Customer> customerOptional = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (customerOptional.isPresent()) {
            throw new CustomerAlreadyExistsException("Mobile number already exists");
        }
        Customer customer = CustomerMapper.toEntity(customerDto);

        customer = customerRepository.save(customer);
        Account account = new Account();
        account.setAccountType(AccountConstants.ACCOUNT_TYPE);
        account.setBranchAddress(AccountConstants.BRANCH_ADDRESS);
        account.setCurrency(AccountConstants.CURRENCY);
        account.setCustomerId(customer.getId());

        accountsRepository.save(account);
    }

    @Override
    public CustomerDto fetchAccountDetails(String mobileNumber) {
        Customer customer =
                customerRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException(
                        AccountConstants.CUSTOMER, AccountConstants.MOBILE_NUMBER, mobileNumber));
        Account account = accountsRepository.findById(customer.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "Customer Id", String.valueOf(customer.getId())));

        CustomerDto customerDto = CustomerMapper.toDto(customer);

        return customerDto;

    }

    @Override
    public void updateAccountDetails(CustomerDto customerDto) {
        Customer customer =
                customerRepository.findByMobileNumber(customerDto.getMobileNumber()).orElseThrow(() -> new ResourceNotFoundException("Customer", "Mobile Number", customerDto.getMobileNumber()));
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customerRepository.save(customer);
    }

    @Override
    public void deteleteAccountDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException(AccountConstants.CUSTOMER, AccountConstants.MOBILE_NUMBER, mobileNumber)
        );
        accountsRepository.deleteById(customer.getId());
        customerRepository.delete(customer);
    }


}
