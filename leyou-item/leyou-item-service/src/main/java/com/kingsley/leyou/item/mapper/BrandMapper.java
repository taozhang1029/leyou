package com.kingsley.leyou.item.mapper;

import com.kingsley.leyou.item.domain.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author kingsley
 * @time 2022/2/12 19:55
 * @ide IntelliJ IDEA
 * @name com.kingsley.leyou.item.mapper.BrandMapper
 * @desc 品牌mapper
 */
public interface BrandMapper extends Mapper<Brand> {
    
    @Insert("INSERT INTO tb_category_brand(category_id, brand_id) VALUES(#{cid}, #{bid})")
    void saveBrandAndCategory(@Param("cid") Long cid, @Param("bid") Long bid);
    
    @Select("SELECT * FROM tb_brand a INNER JOIN tb_category_brand b on a.id = b.brand_id WHERE b.category_id = #{cid}")
    List<Brand> selectByCid(@Param("cid") Long cid);
    
}
