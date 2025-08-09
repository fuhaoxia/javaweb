package com.xfh.mapper;

import com.xfh.domain.Emp;
import com.xfh.domain.EmpQueryParam;
import com.xfh.domain.JobOption;
import org.apache.ibatis.annotations.*;


import java.util.List;
import java.util.Map;


@Mapper
public interface EmpMapper {




    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id=d.id " +
            "order by e.update_time desc ")

    List<Emp> findAllEmp();

    List<Emp> findEmpByCondition(EmpQueryParam empQueryParam);

    void deleteEmpByIds(List<Integer> ids);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp (username,name,gender,phone,job,salary,image,entry_date,dept_id,create_time,update_time)" +
            "values(#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void addEmpInfo(Emp emp);

    Emp findEmpById(Integer id);


    void updateEmyById(Emp emp);

    List<Map<String, Object>> countEmpJobData();

    List<Map<String, Object>> countEmpGenderData();

    @Select("select * from emp")
    List<Emp> findALLEmp();

    @Select("select count(*) from emp where dept_id=#{id}")
    Long countByDeptId(Integer id);

    @Select("select * from emp where username=#{username} and password=#{password}")
    Emp selectByUsernameAndPassword(Emp emp);
}
