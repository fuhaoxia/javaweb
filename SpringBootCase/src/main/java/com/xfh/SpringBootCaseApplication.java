package com.xfh;

import com.xfh.utils.AliyunOSSProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
@EnableConfigurationProperties(AliyunOSSProperties.class)
public class SpringBootCaseApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootCaseApplication.class, args);
    }

}
