package com.henriquebarucco.api.controllers.auth.dto;

public record AuthenticationDTO(
        String login,
        String password
) {
}
