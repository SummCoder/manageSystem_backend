package com.example.manage_backend.exception;

import com.example.manage_backend.common.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 全局异常处理器
     * @param exception
     * @return R
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public R handle(ServiceException exception){
        return R.error(exception.getCode(), exception.getMessage());
    }
}
