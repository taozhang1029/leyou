package com.kingsley.leyou.item.controller;

import com.kingsley.leyou.item.domain.SpecGroup;
import com.kingsley.leyou.item.domain.SpecParam;
import com.kingsley.leyou.item.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author kingsley
 * @time 2022/2/13 20:43
 * @ide IntelliJ IDEA
 * @name com.kingsley.leyou.item.controller.SpecificationController
 * @desc 规格服务
 */
@Controller
@RequestMapping("spec")
public class SpecificationController {
    
    @Autowired
    private SpecificationService specificationService;
    
    /**
     * 根据类目id查询规格分组
     */
    @GetMapping("groups/{cid}")
    public ResponseEntity<List<SpecGroup>> queryGroupsByCid(@PathVariable("cid") Long cid) {
        return ResponseEntity.ok(specificationService.queryGroupsByCid(cid));
    }
    
    /**
     * 根据规格分组id查询规格参数
     */
    @GetMapping("params")
    public ResponseEntity<List<SpecParam>> queryParamsByGid(@RequestParam("gid") Long gid) {
        return ResponseEntity.ok(specificationService.queryParamsByGid(gid));
    }
}
