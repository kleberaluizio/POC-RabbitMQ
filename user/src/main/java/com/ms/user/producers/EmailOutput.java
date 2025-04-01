package com.ms.user.producers;

import java.util.UUID;

public record EmailOutput(UUID userId,
                          String emailTo,
                          String subject,
                          String text) {
}
