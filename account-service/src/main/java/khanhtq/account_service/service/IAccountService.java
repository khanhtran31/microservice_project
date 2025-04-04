package khanhtq.account_service.service;

import khanhtq.account_service.entity.AccountEntity;

import java.util.List;

public interface IAccountService {

    List<AccountEntity> getListAccounts();

    AccountEntity findAccountById(int accountId);
}
