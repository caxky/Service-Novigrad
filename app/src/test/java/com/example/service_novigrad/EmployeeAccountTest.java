package com.example.service_novigrad;

import com.example.service_novigrad.accounts.EmployeeAccount;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeAccountTest {
    @Test
    public void createEmployeeAccount(){
        EmployeeAccount testAccount = new EmployeeAccount("test", "test", "test", "test", 111);

        assertEquals("test", testAccount.getUsername());
    }
}
