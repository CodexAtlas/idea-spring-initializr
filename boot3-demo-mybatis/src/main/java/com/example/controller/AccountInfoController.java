package com.example.controller;

import com.example.entity.AccountInfo;
import com.example.service.AccountInfoService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@Validated
public class AccountInfoController {
    private static final Logger logger = LoggerFactory.getLogger(AccountInfoController.class);

    @Autowired
    private AccountInfoService accountInfoService;

    // 创建账户信息
    @PostMapping
    public ResponseEntity<?> insert(@Valid @RequestBody AccountInfo accountInfo) {
        try {
            int result = accountInfoService.insert(accountInfo);
            if (result > 0) {
                return new ResponseEntity<>("Account created successfully", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Failed to create account", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error("Error creating account", e);
            return new ResponseEntity<>("Error creating account", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 根据账户 ID 查询账户信息
    @GetMapping("/{accountId}")
    public ResponseEntity<?> selectById(@PathVariable Integer accountId) {
        try {
            AccountInfo accountInfo = accountInfoService.selectById(accountId);
            if (accountInfo != null) {
                return new ResponseEntity<>(accountInfo, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error fetching account by ID", e);
            return new ResponseEntity<>("Error fetching account by ID", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 查询所有账户信息
    @GetMapping
    public ResponseEntity<?> selectAll() {
        try {
            List<AccountInfo> accountInfos = accountInfoService.selectAll();
            return new ResponseEntity<>(accountInfos, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error fetching all accounts", e);
            return new ResponseEntity<>("Error fetching all accounts", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 根据账户 ID 更新账户信息
    @PutMapping("/{accountId}")
    public ResponseEntity<?> update(@PathVariable Integer accountId, @Valid @RequestBody AccountInfo accountInfo) {
        try {
            accountInfo.setAccountId(accountId);
            int result = accountInfoService.update(accountInfo);
            if (result > 0) {
                return new ResponseEntity<>("Account updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed to update account", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error("Error updating account", e);
            return new ResponseEntity<>("Error updating account", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 根据账户 ID 删除账户信息
    @DeleteMapping("/{accountId}")
    public ResponseEntity<?> deleteById(@PathVariable Integer accountId) {
        try {
            int result = accountInfoService.deleteById(accountId);
            if (result > 0) {
                return new ResponseEntity<>("Account deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed to delete account", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error("Error deleting account", e);
            return new ResponseEntity<>("Error deleting account", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}    