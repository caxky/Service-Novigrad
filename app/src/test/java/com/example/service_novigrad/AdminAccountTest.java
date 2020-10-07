package com.example.service_novigrad;

import com.example.service_novigrad.accounts.AdminAccount;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdminAccountTest {
    @Test
    public void createAdminAccount(){
        AdminAccount testAccount = new AdminAccount();

        assertEquals("admin", testAccount.getUsername());
    }
}
