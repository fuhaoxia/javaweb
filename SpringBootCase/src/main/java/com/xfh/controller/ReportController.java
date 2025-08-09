package com.xfh.controller;

import com.xfh.domain.ClazzOption;
import com.xfh.domain.JobOption;
import com.xfh.domain.Result;
import com.xfh.service.ReportService;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Resource
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result countEmpJobData(){
        JobOption jobOption = reportService.countEmpJobData();
        return Result.success(jobOption);
    }
    @GetMapping("empGenderData")
    public Result getEmpGenderData(){
         List<Map<String,Object>> gender=reportService.countEmpGender();
        return Result.success(gender);
    }

    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        ClazzOption clazzOption=reportService.getStudentCountData();
        return Result.success(clazzOption);
    }

    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        List<Map<String,Object>> degree=reportService.getStudentDegreeData();
        return Result.success(degree);
    }
}
