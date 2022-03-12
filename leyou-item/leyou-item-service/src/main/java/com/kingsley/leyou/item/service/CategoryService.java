package com.kingsley.leyou.item.service;

import com.kingsley.leyou.item.domain.Brand;
import com.kingsley.leyou.item.domain.Category;
import com.kingsley.leyou.item.mapper.BrandMapper;
import com.kingsley.leyou.item.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    
    @Autowired
    private BrandMapper brandMapper;
    
    public List<Category> listCategoriesByPid(Long pid) {
        Category record = new Category();
        record.setParentId(pid);
        return categoryMapper.select(record);
    }
    
    /**
     * 根据分类id查询分类名称
     * @param ids
     * @return
     */
    public List<String> queryNamesByIds(List<Long> ids) {
        List<Category> categories = categoryMapper.selectByIdList(ids);
        if (CollectionUtils.isEmpty(categories)) {
            return Collections.emptyList();
        }
        return categories.stream().map(Category::getName).collect(Collectors.toList());
    }
    
    /**
     * 根据分类id查询分类的品牌
     * @param cid
     * @return
     */
    public List<Brand> queryCategoriesByCid(Long cid) {
        return brandMapper.selectByCid(cid);
    }
}
