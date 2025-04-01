package com.ms.email.definition;

import java.util.UUID;

public record EmailInput(UUID userId,
                         String emailTo,
                         String subject,
                         String text) {
}
