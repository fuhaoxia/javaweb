package com.xfh.service;

import com.xfh.domain.Dept;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface DeptService {
    List<Dept> findAllDepts();

    void deleteDeptById(Integer id);

    void addDept(Dept  dept);

    Dept getDeptById(Integer id);

    void updateById(Dept dept);


}
