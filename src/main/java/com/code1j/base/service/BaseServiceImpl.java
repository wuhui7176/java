package com.code1j.base.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @ wuhui
 * @ date  2017/9/19下午5:01
 */
public class BaseServiceImpl<T> implements IBaseService<T> {


    private Class clazz;

    public Logger logger = LoggerFactory.getLogger(clazz);

    public BaseServiceImpl(){
        //获取运行时,泛型的实际类型
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] ps = ((ParameterizedType) type).getActualTypeArguments();
            clazz=(Class<T>) ps [0];
        }
    }


}
