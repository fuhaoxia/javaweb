package com.xfh.controller;

import com.xfh.domain.Emp;
import com.xfh.domain.LoginInfo;
import com.xfh.domain.Result;
import com.xfh.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private EmpService empService;

    @PostMapping
    public Result login(@RequestBody Emp emp) {
        LoginInfo loginInfo=empService.login(emp);
        if(loginInfo!=null){
            return Result.success(loginInfo);
        }
        return Result.error("用户名或密码错误");

    }
}
