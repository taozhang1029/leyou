package com.kingsley.leyou.item.controller;

import com.kingsley.leyou.common.domain.PageResult;
import com.kingsley.leyou.item.domain.Brand;
import com.kingsley.leyou.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author kingsley
 * @time 2022/2/12 20:05
 * @ide IntelliJ IDEA
 * @name com.kingsley.leyou.item.controller.BrandController
 * @desc 品牌服务
 */
@Controller
@RequestMapping("brand")
public class BrandController {
    
    @Autowired
    private BrandService brandService;
    
    /**
     * 分页查询品牌
     *
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @param sortBy
     * @param desc
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> pageBrands(@RequestParam(value = "key", required = false) String keyword, @RequestParam(value = "page", defaultValue = "1") Integer pageNum, @RequestParam(value = "rows", defaultValue = "5") Integer pageSize, @RequestParam(value = "sortBy", required = false) String sortBy, @RequestParam(value = "desc", required = false) Boolean desc) {
        PageResult<Brand> brandPageResult = brandService.pageBrands(keyword, pageNum, pageSize, sortBy, desc);
        return ResponseEntity.ok(brandPageResult);
    }
    
    /**
     * 保存品牌
     * @param brand
     * @param cids
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand, @RequestParam("cids") List<Long> cids) {
        brandService.saveBrand(brand, cids);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
}
