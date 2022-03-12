package com.kingsley.leyou.utils.convert;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kingsley
 * @time 2022/2/14 11:15
 * @ide IntelliJ IDEA
 * @name com.kingsley.leyou.utils.convert.BeanConvertUtil
 * @desc bean转换工具类
 */
public class BeanConvertUtil {
    
    public static <F, T> T convert(F source, Class<T> targetClazz) {
        return convert(source, targetClazz, null);
    }
    
    public static <T, F> T convert(F source, Class<T> targetClazz, Converter<F, T> converter) {
        if (source == null) {
            return null;
        }
        try {
            T t = targetClazz.newInstance();
            BeanUtils.copyProperties(source, t);
            if (null != converter) {
                converter.convert(source, t);
            }
            return t;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("BeanConvertUtil convert bean error!", e);
        }
    }
    
    public static <F, T> List<T> convertList(List<F> sources, Class<T> targetClazz) {
        return convertList(sources, targetClazz, null);
    }
    
    public static <F, T> List<T> convertList(List<F> sources, Class<T> targetClazz, Converter<F, T> converter) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.emptyList();
        }
        return sources.stream().map(item -> convert(item, targetClazz, converter)).collect(Collectors.toList());
    }
    
}
