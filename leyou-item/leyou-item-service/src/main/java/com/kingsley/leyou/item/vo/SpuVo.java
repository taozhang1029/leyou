package com.kingsley.leyou.item.vo;

import com.kingsley.leyou.item.domain.Sku;
import com.kingsley.leyou.item.domain.Spu;
import com.kingsley.leyou.item.domain.SpuDetail;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author kingsley
 * @time 2022/2/13 22:42
 * @ide IntelliJ IDEA
 * @name com.kingsley.leyou.item.vo.SpuVo
 * @desc
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SpuVo extends Spu {
    
    /**
     * 类别名称
     */
    private String cname;
    
    /**
     * 品牌名称
     */
    private String bname;
    
    /**
     * spu详情
     */
    private SpuDetail spuDetail;
    
    /**
     * sku列表
     */
    private List<Sku> skus;
    
}
