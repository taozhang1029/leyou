package com.kingsley.leyou.item.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "tb_brand")
public class Brand implements Serializable {
    /**
     * 品牌id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * 品牌名称
     */
    private String name;
    
    /**
     * 品牌图片地址
     */
    private String image;
    
    /**
     * 品牌的首字母
     */
    private Character letter;
    
    private static final long serialVersionUID = 1L;
}

