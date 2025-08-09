package com.xfh.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xfh.domain.*;
import com.xfh.mapper.EmpExprMapper;
import com.xfh.mapper.EmpMapper;
import com.xfh.service.EmpService;
import com.xfh.utils.JwtUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpMapper empMapper;
    @Resource
    private EmpExprMapper empExprMapper;

    @Override
    public PageResult<Emp> findAllEmpPage(Integer pageNo, Integer pageSize) {


        PageHelper.startPage(pageNo, pageSize);
        List<Emp> empAll=empMapper.findAllEmp();

        Page<Emp> page=(Page<Emp>)empAll;


       return new PageResult<>(page.getTotal(),page.getResult());
    }

    @Override
    public PageResult<Emp> findEmpByCondition(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        List<Emp> empAll=empMapper.findEmpByCondition(empQueryParam);

        Page<Emp> page=(Page<Emp>)empAll;

        return new PageResult<>(page.getTotal(),page.getResult());
    }



    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void deleteEmpByIds(List<Integer> ids) {
        //1 删除基本信息
        empMapper.deleteEmpByIds(ids);

        //2 删除工作经历信息
        empExprMapper.deleteEmpExprByEmpIds(ids);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class},propagation = Propagation.REQUIRED )
    public void addEmp(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.addEmpInfo(emp);

        List<EmpExpr> empExprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(empExprList)){
            empExprList.forEach(empExpr-> empExpr.setEmpId(emp.getId()));
            empExprMapper.addBatchExpr(empExprList);
        }
    }

    @Override
    public Emp findEmpInfoById(Integer id) {
        Emp emp = empMapper.findEmpById(id);
        return emp;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void updateEmpById(Emp emp) {
        //根据id修改员工的基本信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateEmyById(emp);


        //先把员工信息全部删除在重新添加
        //这里的修改员工工作经历代码执行的通但是一方面频繁的删除和添加影响性能，
        // 第二删除后添加创建时间改变，从根本上说相当于修改了数据
        empExprMapper.deleteEmpExprByEmpIds(Arrays.asList(emp.getId()));
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(expr -> expr.setEmpId(emp.getId()));
            empExprMapper.addBatchExpr(exprList);
        }
//        第一步：根据员工的id查询相对应的经历然后保存
//        Integer id=emp.getId();
//        List<Integer> oldExprId = empExprMapper.findExprById(id);
//        //第二步：验证传递来的工作经历是否有新添加的或者删除的；新添加的插入数据库；
//        List<EmpExpr> newExprList = emp.getExprList();
//        Map<Integer,EmpExpr> oldExprMap=oldExprId.stream()
//                .collect(Collectors.toMap(exprId->exprId,null));
//        Map<Integer,EmpExpr> newExprMap=newExprList.stream()
//                .collect(Collectors.toMap(EmpExpr::getEmpId,empExpr->empExpr));
//
//        List<EmpExpr> toAdd=newExprList.stream()
//                .filter(expr -> !oldExprMap.containsKey(expr.getId()))
//                .collect(Collectors.toList());
//
//        List<EmpExpr> toUpdate=newExprList.stream()
//                .filter(expr -> oldExprMap.containsKey(expr.getId()))
//                .collect(Collectors.toList());
//        List<Integer> toDelete=oldExprId.stream()
//                .filter(exprId -> !newExprMap.containsKey(exprId))
//                .collect(Collectors.toList());

    }

    @Override
    public List<Emp> findALLEmp() {
        List<Emp> empAll=empMapper.findALLEmp();
        return empAll;
    }

    @Override
    public LoginInfo login(Emp emp) {
        Emp e=empMapper.selectByUsernameAndPassword(emp);
        if (e!=null) {

            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("username", e.getUsername());
            String token = JwtUtil.generateToken(claims);
            return new LoginInfo(e.getId(), e.getUsername(), e.getName(), token);
        }
        return null;
    }
}
