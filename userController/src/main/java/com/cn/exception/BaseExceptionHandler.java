package com.cn.exception;

import com.cn.ReturnCode;
import com.cn.dto.HttpResponse;
import com.cn.dto.ResultData;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BaseExceptionHandler {
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultData<String> handle(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        return ResultData.fail(
                ReturnCode.INVALID_PAR.getCode(),
                fieldError != null ? fieldError.getDefaultMessage() : ReturnCode.INVALID_PAR.getMessage()
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> exception(Exception e) {
        return ResultData.fail(ReturnCode.RC500.getCode(), e.getMessage());
    }
    @ResponseBody
    @ExceptionHandler(CustomException.class)
    public ResultData<String> customException(CustomException e) {
        return ResultData.fail(Integer.parseInt(e.getResultCode()), e.getMessage());
    }
}
