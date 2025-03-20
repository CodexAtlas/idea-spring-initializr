package com.example.mapper;

import com.example.entity.AccountInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountInfoMapper {
    // 创建账户信息
    @Insert("INSERT INTO account_info (user_name, id_card, phone_number, balance) VALUES (#{userName}, #{idCard}, #{phoneNumber}, #{balance})")
    @Options(useGeneratedKeys = true, keyProperty = "accountId")
    int insert(AccountInfo accountInfo);

    // 根据账户 ID 查询账户信息
    @Select("SELECT * FROM account_info WHERE account_id = #{accountId}")
    AccountInfo selectById(Integer accountId);

    // 查询所有账户信息
    @Select("SELECT * FROM account_info")
    List<AccountInfo> selectAll();

    // 根据账户 ID 更新账户信息
    @Update("UPDATE account_info SET user_name = #{userName}, id_card = #{idCard}, phone_number = #{phoneNumber}, balance = #{balance} WHERE account_id = #{accountId}")
    int update(AccountInfo accountInfo);

    // 根据账户 ID 删除账户信息
    @Delete("DELETE FROM account_info WHERE account_id = #{accountId}")
    int deleteById(Integer accountId);
}    