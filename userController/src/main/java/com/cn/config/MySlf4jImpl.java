package com.cn.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class MySlf4jImpl implements Log {
    private final Logger logger = LoggerFactory.getLogger(MySlf4jImpl.class);


    public MySlf4jImpl(String clazz) {
        // Do Nothing
    }

    @Override
    public boolean isDebugEnabled() {
        return log.isInfoEnabled();

    }

    @Override
    public boolean isTraceEnabled() {
        return false;
    }

    @Override
    public void error(String s, Throwable e) {

    }

    @Override
    public void error(String s) {

    }


    @Override
    public void debug(String s) {
        log.info(s);
    }

    @Override
    public void trace(String s) {

    }

    @Override
    public void warn(String s) {

    }


}
