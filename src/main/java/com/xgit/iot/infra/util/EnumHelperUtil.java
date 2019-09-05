package com.xgit.iot.infra.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 此帮助类严格限定为有typeName和typeCode的枚举类
 * 如定义枚举类型为:
 * ADMIN(code,desc)这种
 *
 * @author hz
 * @version 1.0.0
 * @createTime: 2018/12/7 16:35
 */
public class EnumHelperUtil {

    private static String getEnumCodeMethodName ="getCode";

    private static String getEnumDescMethodName ="getDesc";

    /**
     * indexOf,传入的参数ordinal指的是需要的枚举值在设定的枚举类中的顺序，以0开始
     * T
     *
     * @param clazz
     * @param ordinal
     * @return
     */
    public static <T extends Enum<T>> T indexOf(Class<T> clazz, int ordinal) {
        return (T) clazz.getEnumConstants()[ordinal];
    }

    /**
     * nameOf,传入的参数name指的是枚举值的名称，一般是大写加下划线的
     * T
     *
     * @param clazz
     * @param name
     * @return Enum T
     */
    public static <T extends Enum<T>> T nameOf(Class<T> clazz, String name) {

        return (T) Enum.valueOf(clazz, name);
    }

    /**
     * 使用枚举类型对应的typeCode获取枚举类型
     * T
     *
     * @param clazz                 枚举类的class
     * @param typeCode              传入的typeCode值，这个方法为Integer类型
     * @return
     */
    public static <T extends Enum<T>> T getEnumByCode(Class<T> clazz, Object typeCode) {
        T result = null;
        try {
            T[] arr = clazz.getEnumConstants();
            Method TargetMethodGetCode = clazz.getDeclaredMethod(getEnumCodeMethodName);
            Object enumCode = null;
            for (T entity : arr) {
                enumCode = TargetMethodGetCode.invoke(entity);
                if (enumCode.equals(typeCode)) {
                    result = entity;
                    break;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 使用枚举类型对应的typeName获取枚举类型
     * T
     *
     * @param clazz                 枚举类的class
     * @param enumDesc              传入的typeName值，这个方法为String类型
     * @return
     */
    public static <T extends Enum<T>> T getEnumByDesc(Class<T> clazz, String enumDesc) {
        T result = null;
        try {
            T[] arr = clazz.getEnumConstants();
            Method targetMethod = clazz.getDeclaredMethod(getEnumDescMethodName);
            String typeNameVal = null;
            for (T entity : arr) {
                typeNameVal = targetMethod.invoke(entity).toString();
                if (typeNameVal.contentEquals(enumDesc)) {
                    result = entity;
                    break;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return result;
    }

}
