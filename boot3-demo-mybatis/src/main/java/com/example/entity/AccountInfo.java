package com.example.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class AccountInfo {
    private Integer accountId;
    private String userName;
    private String idCard;
    private String phoneNumber;
    private BigDecimal balance;
    private Date createTime;
    private Date updateTime;

}    