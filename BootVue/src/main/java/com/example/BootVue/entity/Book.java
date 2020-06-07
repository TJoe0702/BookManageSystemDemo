package com.example.BootVue.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author tujun
 * @date 2020/6/4 -11:38
 */
@Entity   //对应jpa连接数据库
@Data     //生成各种set get方法

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;



}
