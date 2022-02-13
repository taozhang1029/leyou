package com.kingsley.leyou.item.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * tb_category
 *
 * @author kingsley
 */
@Table(name = "tb_category")
@Data
public class Category implements Serializable {
    /**
     * 类目id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * 类目名称
     */
    @NotEmpty
    private String name;
    
    /**
     * 父类目id,顶级类目填0
     */
    @NotEmpty
    private Long parentId;
    
    /**
     * 是否为父节点，0为否，1为是
     */
    @NotEmpty
    private Boolean isParent;
    
    /**
     * 排序指数，越小越靠前
     */
    @NotEmpty
    private Integer sort;
    
    private static final long serialVersionUID = 1L;
}