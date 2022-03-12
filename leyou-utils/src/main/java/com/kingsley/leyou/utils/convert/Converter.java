package com.kingsley.leyou.utils.convert;

/**
 * @author kingsley
 * @time 2022/2/14 11:17
 * @ide IntelliJ IDEA
 * @name com.kingsley.leyou.utils.convert.Converter
 * @desc 自定义转换接口
 */
public interface Converter<F, T> {
    
    void convert(F source, T target);
    
}
