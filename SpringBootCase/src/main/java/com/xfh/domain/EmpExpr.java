package com.xfh.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpExpr {
    private Integer id;
    private Integer empId;
    private Date begin;
    private Date end;
    private String job;
    private String company;



}
