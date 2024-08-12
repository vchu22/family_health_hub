package io.github.vchu22.family_and_pets_health_tracker.api.service;

import io.github.vchu22.family_and_pets_health_tracker.api.model.Account;
import io.github.vchu22.family_and_pets_health_tracker.api.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account getAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }
}
