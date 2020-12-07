package com.example.service_novigrad;

import com.example.service_novigrad.ui.customer.BranchServiceItem;
import com.example.service_novigrad.ui.customer.CustomerFormRequest;
import com.example.service_novigrad.ui.employee.ServiceRequestItem;
import com.example.service_novigrad.ui.services.FieldsAndAttachments;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ServiceRequestItemTest {
    @Test
    public void createServiceRequestItem(){
        FieldsAndAttachments faa = new FieldsAndAttachments("Health Card Service");
        Map<String, String> testMap = new HashMap<String, String>();
        BranchServiceItem bsi = new BranchServiceItem(555, "Test Service Name", "453453g");

        CustomerFormRequest cfr = new CustomerFormRequest(faa, testMap, testMap, bsi);
        ServiceRequestItem testServiceRequestItem = new ServiceRequestItem(1, "serviceNameTest", cfr);

        assertEquals(false, testServiceRequestItem.getStatus());
        assertEquals("serviceNameTest", testServiceRequestItem.getServiceName());
    }
}
