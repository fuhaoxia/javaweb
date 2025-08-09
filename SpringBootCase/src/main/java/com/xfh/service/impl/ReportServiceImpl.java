package com.xfh.service.impl;

import com.xfh.domain.ClazzOption;
import com.xfh.domain.JobOption;
import com.xfh.mapper.EmpMapper;
import com.xfh.mapper.StudentMapper;
import com.xfh.service.ReportService;
import jakarta.annotation.Resource;
import jakarta.annotation.Resources;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ReportServiceImpl implements ReportService {

    @Resource
    private EmpMapper empMapper;

    @Resource
    private StudentMapper studentMapper;

    @Override
    public JobOption countEmpJobData() {
        List<Map<String, Object>>jobMaps = empMapper.countEmpJobData();

        List<Object> jobs=jobMaps.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> nums=jobMaps.stream().map(dataMap -> dataMap.get("num")).toList();

        return new JobOption(jobs,nums);
    }

    @Override
    public List<Map<String, Object>> countEmpGender() {
        List<Map<String, Object>> gendermaps = empMapper.countEmpGenderData();
        return gendermaps;
    }

    @Override
    public ClazzOption getStudentCountData() {
        List<Map<String,Object>> stus=studentMapper.getStudentCountData();
        List<Object> name = stus.stream().map(stu -> stu.get("name")).toList();
        List<Object> num = stus.stream().map(stu -> stu.get("num")).toList();

        return new  ClazzOption(name,num);
    }

    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        List<Map<String,Object>>  degree=studentMapper.getStudentDegreeData();
        return degree;
    }
}
