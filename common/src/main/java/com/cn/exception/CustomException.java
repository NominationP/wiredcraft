package com.cn.exception;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomException extends RuntimeException implements Serializable {
    public CustomException(String resultMessage) {
        this.resultMessage = resultMessage;
        this.resultCode = "10099";
    }

    public CustomException(String resultMessage, int code) {
        this.resultMessage = resultMessage;
        this.resultCode = String.valueOf(code);
    }

    /**
     * @param resultMessage
     * @return
     */
    public static CustomException abort(String resultMessage) {
        return new CustomException(resultMessage, 20222);
    }


    private String resultMessage;
    private String resultCode;
    private String message;

    public String getMessage(){
        return resultMessage;
    }
}
