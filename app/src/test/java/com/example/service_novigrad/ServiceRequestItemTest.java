package com.example.service_novigrad;

import com.example.service_novigrad.ui.employee.ServiceRequestItem;

import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceRequestItemTest {
    @Test
    public void createServiceRequestItem(){
        ServiceRequestItem testServiceRequestItem = new ServiceRequestItem(1, "serviceNameTest", "userNameTest");

        assertEquals(false, testServiceRequestItem.getStatus());
        assertEquals("serviceNameTest", testServiceRequestItem.getServiceName());
    }
}
