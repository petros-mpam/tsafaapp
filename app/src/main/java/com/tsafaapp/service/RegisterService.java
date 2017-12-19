package com.tsafaapp.service;

import com.tsafaapp.domain.PelatisData;
import com.tsafaapp.utils.ServiceResponse;
import com.tsafaapp.utils.TextUtils;

public class RegisterService {

    public RegisterService() {

    }

    public ServiceResponse validateUserData(final PelatisData user, final String password) {
        if(TextUtils.isEmpty(user.getName())) {
            return ServiceResponse.error("Please enter name");
        }

        if(TextUtils.isEmpty(user.getSurname())) {
            return ServiceResponse.error("Please enter surname");
        }

        if(TextUtils.isEmpty(user.getUsername())) {
            return ServiceResponse.error("Please enter username");
        }

        if(TextUtils.isEmpty(password)) {
            return ServiceResponse.error("Please enter password");
        }

        if(TextUtils.isEmpty(user.getEmail())) {
            return ServiceResponse.error("Please enter email");
        }

        return ServiceResponse.ok();
    }
}
