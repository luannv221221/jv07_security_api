package com.ra.service;

import com.ra.model.Role;
import com.ra.model.User;
import com.ra.model.dto.UserLoginRequestDTO;
import com.ra.model.dto.UserLoginResponse;
import com.ra.model.dto.UserRegisterDTO;
import com.ra.model.dto.UserRegisterResponseDTO;
import com.ra.repository.RoleRepository;
import com.ra.repository.UserRepository;
import com.ra.security.UserPrinciple;
import com.ra.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImp implements AuthService{
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserLoginResponse login(UserLoginRequestDTO userLoginRequestDTO) {
        Authentication authentication;
        authentication = authenticationProvider
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                userLoginRequestDTO.getUsername(),
                                userLoginRequestDTO.getPassword())
                );
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();

        return UserLoginResponse.builder()
                .username(userPrinciple.getUsername())
                .typeToken("Bearer Token")
                .accessToken(jwtProvider.generateToken(userPrinciple))
                .roles(userPrinciple.getUser().getRoles())
                .build();
    }

    @Override
    public UserRegisterResponseDTO register(UserRegisterDTO userRegisterDTO) {
        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findRoleByRoleName("USER");
        roles.add(role);
        User user = User.builder()
                .username(userRegisterDTO.getUsername())
                .password(new BCryptPasswordEncoder().encode(userRegisterDTO.getPassword()))
                .status(true)
                .roles(roles)
                .build();
        User userNew = userRepository.save(user);

        return UserRegisterResponseDTO.builder().username(userNew.getUsername()).build();
    }
}
