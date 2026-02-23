package com.um.helpdesk.dto;

import lombok.Data;
import com.um.helpdesk.entity.UserRole;

@Data // Lombok automatically generates getters and setters
public class UserResponseDTO {
    private Long id;
    private String fullName;
    private String email;
    private UserRole role;
    private boolean active;
}