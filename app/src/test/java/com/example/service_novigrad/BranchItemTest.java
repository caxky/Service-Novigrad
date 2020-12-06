package com.example.service_novigrad;

import com.example.service_novigrad.ui.customer.BranchItem;

import static org.junit.Assert.*;

import org.junit.Test;

public class BranchItemTest {
    @Test
    public void createBranchItem() {
        BranchItem testBranchItem = new BranchItem(1, "321", "8:30", "12:30", "jg0943jg");

        assertEquals("8:30", testBranchItem.getBranchOpen());

        String[] testServicesArray = new String[]{"test"};
        testBranchItem.setbServicesOffered(testServicesArray);
        assertEquals(testServicesArray, testBranchItem.getServicesOffered());
    }
}
