package com.xfh.service;

import com.xfh.domain.Emp;
import com.xfh.domain.EmpQueryParam;
import com.xfh.domain.LoginInfo;
import com.xfh.domain.PageResult;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Transactional
public interface EmpService {

    PageResult<Emp> findAllEmpPage(Integer pageNo, Integer pageSize);

    PageResult<Emp> findEmpByCondition(EmpQueryParam empQueryParam);

    void deleteEmpByIds(List<Integer> ids);

    void addEmp(Emp emp);

    Emp findEmpInfoById(Integer id);

    void updateEmpById(Emp emp);

    List<Emp> findALLEmp();

    LoginInfo login(Emp emp);
}
