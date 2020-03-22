package com.bysj.common.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zyk on 2020/3/21.
 */
public class CommonUtils {


    /**
     * list数据循环copyProperties
     * @param sources
     * @param clazz
     * @param <S>
     * @param <T>
     * @return
     * @author zhangyk
     * @date 2018年6月6日14:57:50
     */
    public static <S, T> List<T> convertBeanList(List<S> sources, Class<T> clazz) {
        return sources.stream().map(source -> convertBean(source, clazz)).collect(Collectors.toList());
    }

    /**
     * 简单属性copy
     * @param s
     * @param clazz
     * @param <S>
     * @param <T>
     * @author zhangyk
     * @date 2018年6月6日14:57:50
     */
    public static <S, T> T convertBean(S s, Class<T> clazz) {
        if (s == null) {
            return null;
        }
        try {
            T t = clazz.newInstance();
            BeanUtils.copyProperties(s, t);
            return t;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("拷贝属性异常");
        }
    }
}
