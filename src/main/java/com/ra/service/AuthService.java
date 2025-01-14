package com.ra.service;

import com.ra.model.dto.UserLoginRequestDTO;
import com.ra.model.dto.UserLoginResponse;
import com.ra.model.dto.UserRegisterDTO;
import com.ra.model.dto.UserRegisterResponseDTO;

public interface AuthService {
    UserLoginResponse login(UserLoginRequestDTO userLoginRequestDTO);
    UserRegisterResponseDTO register(UserRegisterDTO userRegisterDTO);
}
