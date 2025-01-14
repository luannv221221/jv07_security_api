package com.ra.model.dto;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserRegisterDTO {
    private String username;
    private String password;
}
