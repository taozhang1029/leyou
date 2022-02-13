package com.kingsley.leyou.item.service;

import com.kingsley.leyou.item.domain.Category;
import com.kingsley.leyou.item.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kingsley
 * @time 2022/2/12 17:51
 * @ide IntelliJ IDEA
 * @name com.kingsley.leyou.item.service.impl.CategoryServiceImpl
 * @desc 商品类别接口实现类
 */
@Service
public class CategoryService {
    
    @Autowired
    private CategoryMapper categoryMapper;
    
    public List<Category> listCategoriesByPid(Long pid) {
        Category record = new Category();
        record.setParentId(pid);
        return categoryMapper.select(record);
    }
}
