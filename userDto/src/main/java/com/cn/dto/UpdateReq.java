package com.cn.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateReq {
    private String name;
    private Date dob;
    private String address;
    private String description;
}
