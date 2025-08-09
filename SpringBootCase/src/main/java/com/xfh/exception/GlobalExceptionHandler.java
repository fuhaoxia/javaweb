package com.xfh.exception;


import com.xfh.domain.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result handleException(Exception e) {
        log.error("程序出错", e);
        return Result.error("出错了");
    }

    @ExceptionHandler(value = DuplicateKeyException.class)
    public Result handleDuplicateException(DuplicateKeyException e) {
        String eMessage = e.getMessage();
        int index = eMessage.indexOf("Duplicate entry");
        String erroMsg = eMessage.substring(index);
        String key=erroMsg.split(" ")[2];
        return Result.error(key+"重复了");
    }

    @ExceptionHandler(value =ForeignKeyException.class)
    public Result handleForeignKeyException(Exception e) {
       return Result.error(e.getMessage());
    }
}
