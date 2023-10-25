package com.henriquebarucco.api.controllers.auth.dto;

import com.henriquebarucco.api.entities.user.UserRole;

public record RegisterDTO(
        String login,
        String password,
        UserRole role
) {
}
