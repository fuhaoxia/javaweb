package com.xfh.service.impl;

import com.xfh.domain.Dept;
import com.xfh.exception.ForeignKeyException;
import com.xfh.mapper.DeptMapper;
import com.xfh.mapper.EmpMapper;
import com.xfh.service.DeptService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {


    @Resource
    private DeptMapper deptMapper;

    @Resource
    private EmpMapper empMapper;

    @Override
    public List<Dept> findAllDepts() {
        return deptMapper.findAllDepts();
    }

    @Override
    public void deleteDeptById(Integer id) {
        Long count=empMapper.countByDeptId(id);
        if(count>0){
            throw new ForeignKeyException("对不起, 该部门下有员工, 不能直接删除");
        }
        deptMapper.deleteDeptById(id);
    }

    @Override
    public void addDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.addDept(dept);
    }

    @Override
    public Dept getDeptById(Integer id) {

        return deptMapper.getDeptById(id);

    }

    @Override
    public void updateById(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateById(dept);
    }
}
