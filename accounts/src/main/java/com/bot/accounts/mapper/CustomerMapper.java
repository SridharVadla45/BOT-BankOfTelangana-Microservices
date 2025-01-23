package com.bot.accounts.mapper;

import com.bot.accounts.dto.CustomerDto;
import com.bot.accounts.entity.Customer;

public final class CustomerMapper {

    private CustomerMapper() {}


    public static  CustomerDto toDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }


    public static Customer toEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }

}
