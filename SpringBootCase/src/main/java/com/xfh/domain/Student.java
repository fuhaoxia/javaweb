package com.xfh.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String no;
    private Short gender;
    private String phone;
    private String idCard;
    private Short isCollege;
    private String address;
    private Short degree;
    private LocalDate graduationDate;
    private Integer clazzId;
    private Short violationCount;
    private Short violationScore;
    private LocalDate createTime;
    private LocalDate updateTime;

    private String clazzName;
}
