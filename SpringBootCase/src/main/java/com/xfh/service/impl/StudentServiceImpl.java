package com.xfh.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xfh.domain.PageResult;
import com.xfh.domain.Student;
import com.xfh.domain.StudentQueryParam;
import com.xfh.mapper.StudentMapper;
import com.xfh.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> findStudentByConditions(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());
        List<Student> students=studentMapper.findStudentByConditions(studentQueryParam);
        Page<Student> page=(Page<Student>)students;
        return new PageResult<>(page.getTotal(),page.getResult());
    }

    @Override
    public void addStudent(Student student) {
        student.setViolationCount(Short.valueOf("0"));
        student.setViolationScore(Short.valueOf("0"));
        student.setCreateTime(LocalDate.now());
        student.setUpdateTime(LocalDate.now());

        studentMapper.addStudent(student);
    }

    @Override
    public Student findStudentById(String id) {
        Student student=studentMapper.findStudentById(id);
        return student;
    }

    @Override
    public void updateStudent(Student student) {
        student.setUpdateTime(LocalDate.now());
        studentMapper.updateStudent(student);
    }

    @Override
    public void deleteStudentByIds(Integer[] ids) {
        studentMapper.deleteStudentByIds(ids);
    }

    @Override
    public void updateStudentViolation(Integer id, Integer score) {
        studentMapper.updateStudentViolation(id,score);
    }
}
