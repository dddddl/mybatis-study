package com.tjise.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Blob {
    private String id;
    private String title;
    private String author;
    private Date createTime;   //属性名和字段名不一致
    private int views;
}
