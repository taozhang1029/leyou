package com.kingsley.leyou.item.controller;

import com.kingsley.leyou.item.domain.Category;
import com.kingsley.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author kingsley
 * @time 2022/2/12 17:52
 * @ide IntelliJ IDEA
 * @name com.kingsley.leyou.item.controller.CategoryController
 * @desc 商品类别Controller
 */
@Controller
@RequestMapping("category")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;
    
    /**
     * 根据父类目的id查询子类目列表
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> listCategoriesByPid(@RequestParam(value = "pid", defaultValue = "0") Long pid) {
        if (pid == null || pid < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        List<Category> categories = categoryService.listCategoriesByPid(pid);
        return ResponseEntity.ok(categories);
    }
    
}
