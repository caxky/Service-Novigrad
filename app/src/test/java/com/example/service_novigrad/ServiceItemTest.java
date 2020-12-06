package com.example.service_novigrad;

import com.example.service_novigrad.ui.services.FieldsAndAttachments;
import com.example.service_novigrad.ui.services.ServiceItem;

import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceItemTest {
    @Test
    public void createServiceItem(){
        FieldsAndAttachments healthCardFandA = new FieldsAndAttachments("Health Card Service");
        ServiceItem testServiceItem = new ServiceItem("name", "type", "123", healthCardFandA, 25.00);

        assertEquals("type", testServiceItem.getServiceType());
        assertEquals(25.00, testServiceItem.getDefaultPrice());
    }
}
