package com.ra.service;

import com.ra.model.dto.UserLoginRequestDTO;
import com.ra.model.dto.UserLoginResponse;

public interface AuthService {
    UserLoginResponse login(UserLoginRequestDTO userLoginRequestDTO);
}
