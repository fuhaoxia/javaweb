package com.xfh.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentQueryParam {
    private String name;
    private Short degree;
    private Short clazzId;
    private Integer page;
    private Integer pageSize;
}
