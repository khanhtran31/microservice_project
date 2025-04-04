package khanhtq.account_service.service;

import khanhtq.account_service.entity.AccountEntity;
import khanhtq.account_service.repository.IAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService {
    private final IAccountRepository acRepository;

    @Override
    public List<AccountEntity> getListAccounts() {
        return acRepository.findAll();
    }

    @Override
    public AccountEntity findAccountById(int accountId) {
        Optional<AccountEntity> accountEntity = acRepository.findById(accountId);
        return accountEntity.orElse(null);
    }
}
