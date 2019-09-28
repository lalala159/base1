package com.hc.system.exception;

import org.apache.shiro.ShiroException;

public class ExceptionUtil extends ShiroException {
    public ExceptionUtil(){
        super();
    }
    //用详细信息指定一个异常
    public ExceptionUtil(String message){
        super(message);
    }

    //用指定的详细信息和原因构造一个新的异常
    public ExceptionUtil(String message, Throwable cause){
        super(message,cause);
    }

    //用指定原因构造一个新的异常
    public ExceptionUtil(Throwable cause) {
        super(cause);
    }


}
