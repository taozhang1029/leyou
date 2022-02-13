package com.kingsley.leyou.item.domain;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tb_spec_group")
public class SpecGroup implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * 商品分类id，一个分类下有多个规格组
     */
    private Long cid;
    
    /**
     * 规格组的名称
     */
    private String name;
    
    @Transient
    private List<SpecParam> params;
    
    private static final long serialVersionUID = 1L;
}

