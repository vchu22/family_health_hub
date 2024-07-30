package io.github.vchu22.family_and_pets_health_tracker.service;

import io.github.vchu22.family_and_pets_health_tracker.api.model.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private List<Account> accountList;
    public AccountService() {
        accountList = new ArrayList<>();
        Account u1 = new Account(1, "joe", "joe@email.com", "12345678abcd");
        Account u2 = new Account(2, "happy-family", "happy@family.com", "12345678abcd");
        Account u3 = new Account(3, "paw_house", "woof_meow@email.com", "12345678abcd");
        accountList.addAll(Arrays.asList(u1,u2,u3));
    }
    public Optional<Account> getAccount(Integer id) {
        Optional<Account> optional = Optional.empty();
        for (Account account : accountList) {
            if (id == account.getId()) {
                optional = Optional.of(account);
                return optional;
            }
        }
        return optional;
    }
}
