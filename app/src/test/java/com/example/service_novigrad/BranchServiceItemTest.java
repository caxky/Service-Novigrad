package com.example.service_novigrad;

import com.example.service_novigrad.ui.customer.BranchServiceItem;

import static org.junit.Assert.*;

import org.junit.Test;

public class BranchServiceItemTest {
    @Test
    public void createBranchServiceItem() {
        BranchServiceItem testBSItem = new BranchServiceItem(555, "Test Service Name", "453453g");

        assertEquals("Test Service Name", testBSItem.getBranchServiceName());
    }
}
