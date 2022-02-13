package com.kingsley.leyou.item.domain;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_spu_detail")
public class SpuDetail implements Serializable {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long spuId;
    
    /**
     * 商品描述信息
     */
    private String description;
    
    /**
     * 全部规格参数数据
     */
    private String specifications;
    
    /**
     * 特有规格参数及可选值信息，json格式
     */
    private String specTemplate;
    
    /**
     * 包装清单
     */
    private String packingList;
    
    /**
     * 售后服务
     */
    private String afterService;
    
    private static final long serialVersionUID = 1L;
}

