package com.kingsley.leyou.item.mapper;

import com.kingsley.leyou.item.domain.Category;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

public interface CategoryMapper extends Mapper<Category>, SelectByIdListMapper<Category, Long> {

}