package com.xfh.mapper;


import com.xfh.domain.Student;
import com.xfh.domain.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    @Select("select count(*) from student where clazz_id=#{id}")
    Integer countOfClazzId(Integer id);

    List<Student> findStudentByConditions(StudentQueryParam studentQueryParam);

    void addStudent(Student student);

    Student findStudentById(String id);

    void updateStudent(Student student);

    void deleteStudentByIds(Integer[] ids);

    void updateStudentViolation(Integer id, Integer score);

    List<Map<String, Object>> getStudentCountData();

    List<Map<String, Object>> getStudentDegreeData();
}
