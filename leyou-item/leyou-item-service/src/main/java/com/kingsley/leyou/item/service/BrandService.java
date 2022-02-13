package com.kingsley.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kingsley.leyou.common.domain.PageResult;
import com.kingsley.leyou.item.domain.Brand;
import com.kingsley.leyou.item.mapper.BrandMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author kingsley
 * @time 2022/2/12 20:08
 * @ide IntelliJ IDEA
 * @name com.kingsley.leyou.item.service.impl.BrandServiceImpl
 * @desc 品牌接口
 */
@Service
public class BrandService {
    
    @Autowired
    private BrandMapper brandMapper;
    
    /**
     * 分页查询品牌
     *
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @param sortBy
     * @param desc
     * @return
     */
    public PageResult<Brand> pageBrands(String keyword, Integer pageNum, Integer pageSize, String sortBy, Boolean desc) {
        // 初始化Example对象
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        
        // 添加模糊查询
        if (!StringUtils.isBlank(keyword)) {
            criteria.andLike("name", "%" + keyword + "%").orEqualTo("letter", keyword);
        }
        
        // 添加分页
        PageHelper.startPage(pageNum, pageSize);
        
        // 添加排序
        if (!StringUtils.isBlank(sortBy)) {
            example.setOrderByClause(sortBy + (desc ? " desc" : " asc"));
        }
        
        List<Brand> brands = brandMapper.selectByExample(example);
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);
        
        // int total = brandMapper.selectCountByExample(example);
        // return new PageResult<>(brands, total, total % pageNum == 0 ? total / pageNum : total / pageNum + 1);
        
        return new PageResult<>(pageInfo.getList(), pageInfo.getTotal(), pageInfo.getPages());
    }
    
    /**
     * 新增品牌
     *
     * @param brand 品牌信息
     * @param cids  品牌所属类目id列表
     */
    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {
        brandMapper.insertSelective(brand);
        Long brandId = brand.getId();
        if (!CollectionUtils.isEmpty(cids)) {
            cids.forEach(cid -> brandMapper.saveBrandAndCategory(cid, brandId));
        }
    }
}
