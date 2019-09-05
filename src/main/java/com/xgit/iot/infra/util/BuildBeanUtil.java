package com.xgit.iot.infra.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Component
public class BuildBeanUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BuildBeanUtil.applicationContext = applicationContext;
    }

    public static Object getBean(Class clazz){
       return applicationContext.getBean(clazz);
    }

    public static Object getBean(String clazzName){
        return applicationContext.getBean(clazzName);
    }
}
