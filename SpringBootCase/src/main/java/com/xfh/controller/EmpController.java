package com.xfh.controller;

import com.xfh.domain.Emp;
import com.xfh.domain.EmpQueryParam;
import com.xfh.domain.PageResult;
import com.xfh.domain.Result;
import com.xfh.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/emps")
public class EmpController {



    @Resource
    private EmpService empService;

//    @GetMapping
//    public Result findAllEmp(@RequestParam(defaultValue = "1") Integer page,
//                             @RequestParam(defaultValue = "10") Integer pageSize) {
//        PageResult<Emp> allEmp=empService.findAllEmpPage(page,pageSize);
//        return Result.success(allEmp);
//    }

//    @GetMapping
//    public Result findEmpByConditions(String name, Short gender,
//                                      @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
//                                      @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
//                                      Integer page, Integer pageSize) {
//
//        PageResult<Emp> allEmp=empService.findEmpByCondition(name,gender,begin,end,page,pageSize);
//        return Result.success(allEmp);
//
//    }

    @GetMapping
    public Result findEmpByConditions(EmpQueryParam empQueryParam) {

        PageResult<Emp> allEmp=empService.findEmpByCondition(empQueryParam);
        return Result.success(allEmp);

    }
    @GetMapping("/list")
    public Result findALLEmp() {

        List<Emp> allEmp=empService.findALLEmp();
        return Result.success(allEmp);

    }

    @PostMapping
    public Result addEmp(@RequestBody Emp emp) {
        empService.addEmp(emp);
        return Result.success();
    }


    @DeleteMapping
    public Result deleteEmpByIds(@RequestParam List<Integer> ids) {
        empService.deleteEmpByIds(ids);
        return Result.success();
    }

    @GetMapping({"/{id}"})
    public Result findEmpInfoById(@PathVariable("id") Integer id) {
        Emp empInfo = empService.findEmpInfoById(id);

        return Result.success(empInfo);
    }
    @PutMapping
    public Result updateEmpById(@RequestBody Emp emp) {
        empService.updateEmpById(emp);
        return Result.success();
    }
}
