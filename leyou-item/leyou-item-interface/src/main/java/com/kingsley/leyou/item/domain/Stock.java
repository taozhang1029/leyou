package com.kingsley.leyou.item.domain;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_stock")
public class Stock implements Serializable {
    /**
     * 库存对应的商品sku id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skuId;
    
    /**
     * 可秒杀库存
     */
    private Integer seckillStock;
    
    /**
     * 秒杀总数量
     */
    private Integer seckillTotal;
    
    /**
     * 库存数量
     */
    private Integer stock;
    
    private static final long serialVersionUID = 1L;
}

