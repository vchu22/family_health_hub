package io.github.vchu22.family_and_pets_health_tracker.api.controller;

import io.github.vchu22.family_and_pets_health_tracker.api.model.Account;
import io.github.vchu22.family_and_pets_health_tracker.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/account")
    public Account getAccount(@RequestParam Integer id) {
        Optional account = accountService.getAccount(id);
        if (account.isPresent()) {
            return (Account) account.get();
        }
        return null;
    }
}
