package com.xfh.controller;

import com.xfh.domain.PageResult;
import com.xfh.domain.Result;
import com.xfh.domain.Student;
import com.xfh.domain.StudentQueryParam;
import com.xfh.service.StudentService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping
    public Result findStudentByConditions(StudentQueryParam studentQueryParam) {
        PageResult<Student> students=studentService.findStudentByConditions(studentQueryParam);

        return Result.success(students);
    }

    @PostMapping
    public Result addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result findStudentById(@PathVariable String id){
        Student student=studentService.findStudentById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result deleteStudentByIds(@PathVariable("ids") Integer[] ids){
        studentService.deleteStudentByIds(ids);
        return  Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result updateStudentViolation(@PathVariable("id") Integer id,@PathVariable("score") Integer score){
        studentService.updateStudentViolation(id,score);
        return Result.success();
    }
}
