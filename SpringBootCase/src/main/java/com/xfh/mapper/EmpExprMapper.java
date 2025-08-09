package com.xfh.mapper;

import com.xfh.domain.EmpExpr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    void addBatchExpr(List<EmpExpr> empExprList);



    void deleteEmpExprByEmpIds(List<Integer> empIds);

    @Select("select id from emp_expr where emp_id=#{id}")
    List<Integer> findExprById(Integer id);
}
