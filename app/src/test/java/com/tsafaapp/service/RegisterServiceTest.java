package com.tsafaapp.service;

import com.tsafaapp.domain.PelatisData;
import com.tsafaapp.utils.ServiceResponse;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegisterServiceTest {

    private RegisterService registerService;

    @Before
    public void setup() {
        registerService = new RegisterService();
    }

    @Test
    public void validateUserData_withoutUsername_shouldProduceError() {
        PelatisData pelatis = new PelatisData();
        pelatis.setName("ValidName");
        pelatis.setSurname("ValidSurname");
        pelatis.setEmail("valid@email.com");

        ServiceResponse resp = registerService.validateUserData(pelatis, "");

        assertTrue(resp.isError());
    }

    @Test
    public void validateUserData_withValidData_shouldSucceed() {
        PelatisData pelatis = new PelatisData();
        pelatis.setName("ValidName");
        pelatis.setSurname("ValidSurname");
        pelatis.setEmail("valid@email.com");
        pelatis.setUsername("validusername");

        ServiceResponse resp = registerService.validateUserData(pelatis, "VALID_PASS");

        assertFalse(resp.isError());
    }
}