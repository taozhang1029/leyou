package com.kingsley.leyou.item.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_spu")
public class Spu implements Serializable {
    /**
     * spu id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * 标题
     */
    private String title;
    
    /**
     * 子标题
     */
    private String subTitle;
    
    /**
     * 1级类目id
     */
    private Long cid1;
    
    /**
     * 2级类目id
     */
    private Long cid2;
    
    /**
     * 3级类目id
     */
    private Long cid3;
    
    /**
     * 商品所属品牌id
     */
    private Long brandId;
    
    /**
     * 是否上架，0下架，1上架
     */
    private Boolean saleable;
    
    /**
     * 是否有效，0已删除，1有效
     */
    private Boolean valid;
    
    /**
     * 添加时间
     */
    private Date createTime;
    
    /**
     * 最后修改时间
     */
    private Date lastUpdateTime;
    
    private static final long serialVersionUID = 1L;
}

