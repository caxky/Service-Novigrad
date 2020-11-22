package com.example.service_novigrad;

import com.example.service_novigrad.accounts.CustomerAccount;
import com.example.service_novigrad.accounts.EmployeeAccount;
import com.example.service_novigrad.ui.accounts.AccountItem;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountItemTest {
    @Test
    public void createAccountItem(){
        CustomerAccount testCustomer = new CustomerAccount("customer123", "password", "first", "last", 123456, "key");
        EmployeeAccount testEmployee = new EmployeeAccount("employee123", "password", "first", "last", 123, 123456, "key");
        AccountItem testCustomerAccountItem = new AccountItem(1, testCustomer);
        AccountItem testEmployeeAccountItem = new AccountItem(1, testEmployee);

        assertEquals("customer123", testCustomerAccountItem.getUsername());
        assertEquals("employee123", testEmployeeAccountItem.getUsername());
    }
}
