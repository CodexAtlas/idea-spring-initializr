package com.example.service;

import com.example.entity.AccountInfo;

import java.util.List;

public interface AccountInfoService {
    int insert(AccountInfo accountInfo);
    AccountInfo selectById(Integer accountId);
    List<AccountInfo> selectAll();
    int update(AccountInfo accountInfo);
    int deleteById(Integer accountId);
}    