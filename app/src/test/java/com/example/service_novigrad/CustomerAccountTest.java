package com.example.service_novigrad;

import com.example.service_novigrad.accounts.CustomerAccount;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerAccountTest {
    @Test
    public void createCustomerAccount(){
        CustomerAccount testAccount = new CustomerAccount("test", "test", "test", "test", 123, "test");

        assertEquals("test", testAccount.getUsername());
    }
}
