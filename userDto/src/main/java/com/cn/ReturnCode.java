package com.cn;

public enum ReturnCode {
    RC100(10000,"success"),
    RC500(50000,"error"),
    INVALID_PAR(4002,"parameter error");


    private final int code;
    private final String message;

    ReturnCode(int code, String message){
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

