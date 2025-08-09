package com.xfh.mapper;

import com.xfh.domain.Clazz;
import com.xfh.domain.ClazzQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface ClazzMapper {

     List<Clazz> findAllClazzByConditions(ClazzQueryParam clazzQueryParam);
    @Insert("insert into clazz values (null,#{name},#{room},#{beginDate},#{endDate}," +
            "#{masterId},#{subject},#{createTime},#{updateTime})")
    void addClazz(Clazz clazz);

    @Select("select * from clazz where id=#{id}")
    Clazz findClazzById(Integer id);

    void updateClazz(Clazz clazz);
    @Delete("delete from clazz where id=#{id}")
    void deleteClazzById(Integer id);

    @Select("select * from clazz")
    List<Clazz> findAllClazz();
}
