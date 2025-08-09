package com.xfh;

import com.xfh.utils.AliyunOSSProperties;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;

public class test {

    @Resource
    private AliyunOSSProperties aliyunOSSProperties;

    @Test
    public void out(){
        System.out.println(aliyunOSSProperties);
        }
}
