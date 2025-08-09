package com.xfh.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Short gender;
    private String phone;
    private String image;
    private Short job;
    private LocalDate entryDate;
    private Integer deptId;
    private Integer salary;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private String deptName;

    private List<EmpExpr> exprList;
}
