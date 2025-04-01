package com.ms.user.definition;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserInput(@NotBlank String name,
                        @NotBlank @Email String email) { }