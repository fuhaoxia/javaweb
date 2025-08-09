package com.xfh.mapper;

import com.xfh.domain.Dept;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    List<Dept> findAllDepts();

    @Delete("delete from dept where id=#{id}")
    void deleteDeptById(Integer id);

    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void addDept(Dept dept);

    @Select("select * from dept where id=#{id}")
    Dept getDeptById(Integer id);

    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    void updateById(Dept dept);
}
