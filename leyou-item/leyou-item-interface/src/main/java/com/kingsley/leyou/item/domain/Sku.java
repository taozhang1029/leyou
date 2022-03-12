package com.kingsley.leyou.item.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tb_sku")
public class Sku implements Serializable {
    /**
     * sku id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * spu id
     */
    private Long spuId;
    
    /**
     * 商品标题
     */
    private String title;
    
    /**
     * 商品的图片，多个图片以‘,’分割
     */
    private String images;
    
    /**
     * 销售价格，单位为分
     */
    private Long price;
    
    /**
     * 特有规格属性在spu属性模板中的对应下标组合
     */
    private String indexes;
    
    /**
     * sku的特有规格参数键值对，json格式，反序列化时请使用linkedHashMap，保证有序
     */
    private String ownSpec;
    
    /**
     * 是否有效，0无效，1有效
     */
    private Boolean enable;
    
    /**
     * 添加时间
     */
    private Date createTime;
    
    /**
     * 最后修改时间
     */
    private Date lastUpdateTime;
    
    /**
     * 库存
     */
    @Transient
    private Integer stock;
    
    private static final long serialVersionUID = 1L;
}

