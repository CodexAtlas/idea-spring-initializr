package com.example.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class User {
    @Id // 标识这是主键
    private String id; // 主键字段
    private String name;
    private String sex;
    private String age;
}
