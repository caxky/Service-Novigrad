package com.example.service_novigrad;

import com.example.service_novigrad.ui.register.Branch;

import org.junit.Test;

import static org.junit.Assert.*;

public class BranchTest {
    @Test
    public void createBranch(){
        Branch testBranch1 = new Branch(123, "testkey");

        assertEquals(123, testBranch1.getBranchID());
        assertEquals("testkey", testBranch1.getBranchFirebaseKey());

        Branch testBranch2 = new Branch("testkey", "1", "2", "3", "4", "5", "6", "1", "2", "3", "4", "5", "6", "7", "8", 123, "1234567890", "test@email.com");

        assertEquals("6", testBranch2.getSaturdayClosingHours());
        assertEquals("2", testBranch2.getMondayClosingHours());
        assertEquals("1234567890", testBranch2.getPhoneNumber());
        assertEquals("test@email.com", testBranch2.getEmailAddress());
    }
}
