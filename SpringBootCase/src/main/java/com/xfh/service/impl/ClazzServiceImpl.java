package com.xfh.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xfh.domain.Clazz;
import com.xfh.domain.ClazzQueryParam;
import com.xfh.domain.PageResult;
import com.xfh.exception.ForeignKeyException;
import com.xfh.mapper.ClazzMapper;
import com.xfh.mapper.StudentMapper;
import com.xfh.service.ClazzService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Resource
    private ClazzMapper clazzMapper;

    @Resource
    private StudentMapper studentMapper;

    @Override
    public PageResult<Clazz> findAllClazzByConditions(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(),clazzQueryParam.getPageSize());
        LocalDate nowTime=LocalDate.now();
        List<Clazz> allClazz = clazzMapper.findAllClazzByConditions(clazzQueryParam);
        allClazz.stream().peek(clazz->{
            if(clazz.getEndDate().isBefore(nowTime)){
                clazz.setStatus("已结课");
            }else if(clazz.getBeginDate().isAfter(nowTime)){
                clazz.setStatus("未开始");
            }else {
                clazz.setStatus("进行中");
            }
        }).toList();
        Page<Clazz> allPage=(Page<Clazz>)allClazz;

        return new PageResult<>(allPage.getTotal(),allPage.getResult());
    }

    @Override
    public void addClazz(Clazz clazz) {
        clazz.setCreateTime(LocalDate.now());
        clazz.setUpdateTime(LocalDate.now());
        clazzMapper.addClazz(clazz);
    }

    @Override
    public Clazz findClazzById(Integer id) {
        Clazz clazz=clazzMapper.findClazzById(id);
        return clazz;
    }

    @Override
    public void updateClazz(Clazz clazz) {
        clazz.setUpdateTime(LocalDate.now());
        clazzMapper.updateClazz(clazz);
    }

    @Override
    public void deleteClazzById(Integer id)  {

        Integer count=studentMapper.countOfClazzId(id);
        if(count>0){
            throw new ForeignKeyException("对不起, 该班级下有学生, 不能直接删除");
        }
        clazzMapper.deleteClazzById(id);
    }

    @Override
    public List<Clazz> findAllClazz() {
        List<Clazz> allClazz=clazzMapper.findAllClazz();
        return allClazz;
    }

}
