package com.xfh.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClazzQueryParam {
    private String name;

    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate begin;
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate end;
    private Integer page;
    private Integer pageSize;
}
