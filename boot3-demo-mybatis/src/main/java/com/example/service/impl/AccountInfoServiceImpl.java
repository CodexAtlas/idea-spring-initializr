package com.example.service.impl;

import com.example.entity.AccountInfo;
import com.example.mapper.AccountInfoMapper;
import com.example.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountInfoServiceImpl implements AccountInfoService {
    @Autowired
    private AccountInfoMapper accountInfoMapper;

    @Override
    public int insert(AccountInfo accountInfo) {
        return accountInfoMapper.insert(accountInfo);
    }

    @Override
    public AccountInfo selectById(Integer accountId) {
        return accountInfoMapper.selectById(accountId);
    }

    @Override
    public List<AccountInfo> selectAll() {
        return accountInfoMapper.selectAll();
    }

    @Override
    public int update(AccountInfo accountInfo) {
        return accountInfoMapper.update(accountInfo);
    }

    @Override
    public int deleteById(Integer accountId) {
        return accountInfoMapper.deleteById(accountId);
    }
}    