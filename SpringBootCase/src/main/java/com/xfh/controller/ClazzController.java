package com.xfh.controller;

import com.xfh.domain.Clazz;
import com.xfh.domain.ClazzQueryParam;
import com.xfh.domain.PageResult;
import com.xfh.domain.Result;
import com.xfh.service.ClazzService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Resource
    private ClazzService clazzService;



   @GetMapping
    public Result findClazzByConditions(ClazzQueryParam clazzQueryParam){
        PageResult<Clazz>  allClazz=clazzService.findAllClazzByConditions(clazzQueryParam);
        return Result.success(allClazz);
    }
    @DeleteMapping("/{id}")
    public Result deleteClazzById(@PathVariable("id") Integer id){
        clazzService.deleteClazzById(id);
       return Result.success();
    }

    @PostMapping
    public Result addClazz(@RequestBody Clazz clazz){
       clazzService.addClazz(clazz);
       return Result.success();
    }

    @GetMapping("/{id}")
    public Result findClazzById(@PathVariable("id") Integer id){
       Clazz clazz=clazzService.findClazzById(id);
       return Result.success(clazz);
    }
    @PutMapping
    public Result updateClazz(@RequestBody Clazz clazz){
       clazzService.updateClazz(clazz);
       return Result.success();
    }
    @GetMapping("/list")
    public Result findAllClazz(){
       List<Clazz> allClazz=clazzService.findAllClazz();
       return  Result.success(allClazz);
    }

}
