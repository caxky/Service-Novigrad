package com.example.service_novigrad;

import com.example.service_novigrad.accounts.CustomerAccount;
import com.example.service_novigrad.accounts.EmployeeAccount;
import com.example.service_novigrad.ui.accounts.AccountItem;
import com.example.service_novigrad.ui.customer.BranchServiceItem;
import com.example.service_novigrad.ui.customer.CustomerFormRequest;
import com.example.service_novigrad.ui.employee.ServiceRequestItem;
import com.example.service_novigrad.ui.register.Branch;
import com.example.service_novigrad.ui.services.FieldsAndAttachments;
import com.example.service_novigrad.ui.services.ServiceItem;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ChangingValuesTest {
    @Test
    public void changeServiceItem(){
        FieldsAndAttachments healthCardFandA = new FieldsAndAttachments("Health Card Service");
        ServiceItem testServiceItem = new ServiceItem("name", "type", "123", healthCardFandA, 25.00);

        assertEquals("type", testServiceItem.getServiceType());

        testServiceItem.changeText1("newName");

        assertEquals("newName", testServiceItem.getServiceName());
    }

    @Test
    public void changeServiceRequestItem(){
        FieldsAndAttachments faa = new FieldsAndAttachments("Health Card Service");
        Map<String, String> testMap = new HashMap<String, String>();
        BranchServiceItem bsi = new BranchServiceItem(555, "Test Service Name", "453453g");

        CustomerFormRequest cfr = new CustomerFormRequest(faa, testMap, testMap, bsi);
        ServiceRequestItem testServiceRequestItem = new ServiceRequestItem(1, "serviceNameTest", cfr);

        assertEquals(false, testServiceRequestItem.getStatus());
        assertEquals("serviceNameTest", testServiceRequestItem.getServiceName());

        testServiceRequestItem.setStatus(true);

        assertEquals(true, testServiceRequestItem.getStatus());
        assertEquals("serviceNameTest", testServiceRequestItem.getServiceName());
    }

    @Test
    public void changeBranch(){
        Branch testBranch = new Branch("testkey", "1", "2", "3", "4", "5", "6", "1", "2", "3", "4", "5", "6", "7", "8", 123, "1234567890", "test@email.com");

        assertEquals("1234567890", testBranch.getPhoneNumber());
        assertEquals("test@email.com", testBranch.getEmailAddress());

        testBranch.setPhoneNumber("1112223333");
        testBranch.setEmailAddress("branch@branch.com");

        assertEquals("1112223333", testBranch.getPhoneNumber());
        assertEquals("branch@branch.com", testBranch.getEmailAddress());
    }

    @Test
    public void changeFieldsAndAttachments(){
        FieldsAndAttachments testFandA = new FieldsAndAttachments("Photo ID Service");

        assertEquals(true, testFandA.isAddress());

        testFandA.setAddress(false);

        assertEquals(false, testFandA.isAddress());
    }
}
