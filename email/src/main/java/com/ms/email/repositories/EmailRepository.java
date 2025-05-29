package com.ms.email.repositories;

import com.ms.email.definition.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<EmailModel, UUID> {
}
