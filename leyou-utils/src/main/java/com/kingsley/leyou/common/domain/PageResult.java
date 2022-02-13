package com.kingsley.leyou.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author kingsley
 * @time 2022/2/12 19:59
 * @ide IntelliJ IDEA
 * @name com.kingsley.leyou.common.domain.PageResult
 * @desc 分页对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {
    
    private List<T> items;
    
    private Long total;
    
    private Integer totalPage;
    
}
