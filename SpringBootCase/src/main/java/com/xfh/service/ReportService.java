package com.xfh.service;

import com.xfh.domain.ClazzOption;
import com.xfh.domain.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption countEmpJobData();

    List<Map<String, Object>> countEmpGender();

    ClazzOption getStudentCountData();

    List<Map<String, Object>> getStudentDegreeData();
}
