package com.code1j.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ wuhui
 * @ date  2017/9/19下午4:27
 */
public  class LoggerTest<E> {

    private static Class clazz;

    /*

    日志测试

     */
//    public static Logger logger = LoggerFactory.getLogger(LoggerTest.class);


    public static void main(String[] args) {
        logger.error("sssssssss");
        logger.debug("bbbbbb");
    }



    public static Logger logger = LoggerFactory.getLogger(clazz);
}
