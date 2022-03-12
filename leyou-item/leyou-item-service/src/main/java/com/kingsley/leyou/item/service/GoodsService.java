package com.kingsley.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kingsley.leyou.common.domain.PageResult;
import com.kingsley.leyou.item.domain.*;
import com.kingsley.leyou.item.mapper.*;
import com.kingsley.leyou.item.vo.SpuVo;
import com.kingsley.leyou.utils.convert.BeanConvertUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * @author kingsley
 * @time 2022/2/13 22:33
 * @ide IntelliJ IDEA
 * @name com.kingsley.leyou.item.service.GoodsService
 * @desc 商品接口
 */
@Service
public class GoodsService {
    
    @Autowired
    private SpuMapper spuMapper;
    
    @Autowired
    private SkuMapper skuMapper;
    
    @Autowired
    private StockMapper stockMapper;
    
    @Autowired
    private SpuDetailMapper spuDetailMapper;
    
    @Autowired
    private BrandMapper brandMapper;
    
    @Autowired
    private CategoryService categoryService;
    
    public PageResult<SpuVo> pageSpu(String keyword, Boolean saleable, Integer pageNum, Integer pageSize) {
        Example example = new Example(Spu.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isBlank(keyword)) {
            criteria.andLike("title", "%" + keyword + "%");
        }
        
        if (saleable != null) {
            criteria.andEqualTo("saleable", saleable);
        }
        
        PageHelper.startPage(pageNum, pageSize);
        List<Spu> spuList = spuMapper.selectByExample(example);
        PageInfo<Spu> spuPageInfo = new PageInfo<>(spuList);
    
        List<SpuVo> spuVos = BeanConvertUtil.convertList(spuList, SpuVo.class, (source, target) -> {
            Brand brand = brandMapper.selectByPrimaryKey(source.getBrandId());
            if (brand == null) {
                throw new RuntimeException("品牌不存在！");
            }
            target.setBname(brand.getName());
            
            List<String> names = categoryService.queryNamesByIds(Arrays.asList(source.getCid1(), source.getCid2(), source.getCid3()));
            String cname = StringUtils.join(names, " - ");
            target.setCname(cname);
        });
        
        return new PageResult<>(spuVos, spuPageInfo.getTotal(), spuPageInfo.getPages());
    }
    
    @Transactional
    public Long saveGoods(SpuVo spuVo) {
        // 新增Spu
        spuVo.setId(null);
        spuVo.setSaleable(true);
        spuVo.setValid(true);
        spuVo.setCreateTime(new Date());
        spuVo.setLastUpdateTime(spuVo.getCreateTime());
        spuMapper.insertSelective(spuVo);
        Long spuId = spuVo.getId();
    
        // 新增SpuDetail
        SpuDetail spuDetail = spuVo.getSpuDetail();
        spuDetail.setSpuId(spuId);
        spuDetailMapper.insertSelective(spuDetail);
        
        spuVo.getSkus().forEach(sku -> {
            // 保存sku
            sku.setId(null);
            sku.setSpuId(spuId);
            sku.setCreateTime(new Date());
            sku.setLastUpdateTime(sku.getCreateTime());
            skuMapper.insertSelective(sku);
            
            // 保存stock
            Stock stock = new Stock();
            stock.setSkuId(sku.getId());
            stock.setStock(sku.getStock());
            stockMapper.insertSelective(stock);
        });
        
        return spuId;
    }
    
    public SpuDetail querySpuDetailBySpuId(Long spuId) {
        return spuDetailMapper.selectByPrimaryKey(spuId);
    }
    
    public List<Sku> querySkuListBySpuId(Long spuId) {
        Example example = new Example(Sku.class);
        example.createCriteria().andEqualTo("spuId", spuId);
        List<Sku> skus = skuMapper.selectByExample(example);
        skus.forEach(sku -> {
            Stock stock = stockMapper.selectByPrimaryKey(sku.getId());
            sku.setStock(stock.getStock());
        });
        return skus;
    }
}
