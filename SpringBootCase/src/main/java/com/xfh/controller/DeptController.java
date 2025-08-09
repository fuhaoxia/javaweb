package com.xfh.controller;

import com.xfh.domain.Dept;
import com.xfh.domain.Result;
import com.xfh.service.DeptService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/depts")
public class DeptController {

    //private  static Logger logger = LoggerFactory.getLogger(DeptController.class);
    @Resource
    private DeptService deptService;


    @GetMapping
    public Result getDepts(){
//        log.info("查询全部部门数据");
        List<Dept> allDepts = deptService.findAllDepts();

        return Result.success(allDepts);
    }

    @DeleteMapping
    public Result deleteDeptById( Integer id){
        log.info("根据id删除部门");
        deptService.deleteDeptById(id);
        return Result.success();
    }

    @PostMapping
    public Result addDept(@RequestBody Dept dept){
        deptService.addDept(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getDeptById(@PathVariable("id") Integer id){
        log.info("查询全部部门数据");
       Dept dept=deptService.getDeptById(id);

        return Result.success(dept);
    }

    @PutMapping
    public Result updateDept(@RequestBody Dept dept){
        deptService.updateById(dept);
        return Result.success();

    }
}
