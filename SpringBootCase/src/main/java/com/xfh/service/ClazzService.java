package com.xfh.service;

import com.xfh.domain.Clazz;
import com.xfh.domain.ClazzQueryParam;
import com.xfh.domain.PageResult;

import java.util.List;

public interface ClazzService {
    PageResult<Clazz> findAllClazzByConditions(ClazzQueryParam clazzQueryParam);

    void addClazz(Clazz clazz);

    Clazz findClazzById(Integer id);

    void updateClazz(Clazz clazz);

    void deleteClazzById(Integer id) ;

    List<Clazz> findAllClazz();
}
