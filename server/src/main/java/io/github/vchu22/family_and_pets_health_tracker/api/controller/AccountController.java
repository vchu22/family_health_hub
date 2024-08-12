package io.github.vchu22.family_and_pets_health_tracker.api.controller;

import io.github.vchu22.family_and_pets_health_tracker.api.model.Account;
import io.github.vchu22.family_and_pets_health_tracker.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return ResponseEntity.ok(createdAccount);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Account> getAccount(@PathVariable String username) {
        Account account = accountService.getAccountByUsername(username);
        return account != null ? ResponseEntity.ok(account) : ResponseEntity.notFound().build();
    }
}