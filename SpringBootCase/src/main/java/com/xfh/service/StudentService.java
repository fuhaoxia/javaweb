package com.xfh.service;

import com.xfh.domain.PageResult;
import com.xfh.domain.Student;
import com.xfh.domain.StudentQueryParam;

public interface StudentService {
    PageResult<Student> findStudentByConditions(StudentQueryParam studentQueryParam);

    void addStudent(Student student);

    Student findStudentById(String id);

    void updateStudent(Student student);

    void deleteStudentByIds(Integer[] ids);

    void updateStudentViolation(Integer id, Integer score);
}
