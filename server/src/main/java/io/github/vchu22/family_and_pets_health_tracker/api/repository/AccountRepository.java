package io.github.vchu22.family_and_pets_health_tracker.api.repository;

import io.github.vchu22.family_and_pets_health_tracker.api.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
    Account findByUsername(String username);
}
