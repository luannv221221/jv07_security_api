package com.ra.model.dto;

import com.ra.model.Role;
import lombok.*;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserPermissionDTO {
    private Set<String> roleName;
}
