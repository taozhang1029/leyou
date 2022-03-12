package com.kingsley.leyou.item.controller;

import com.kingsley.leyou.common.domain.PageResult;
import com.kingsley.leyou.item.domain.Sku;
import com.kingsley.leyou.item.domain.SpuDetail;
import com.kingsley.leyou.item.service.GoodsService;
import com.kingsley.leyou.item.vo.SpuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kingsley
 * @time 2022/2/13 22:34
 * @ide IntelliJ IDEA
 * @name com.kingsley.leyou.item.controller.GoodsController
 * @desc 商品服务
 */
@Controller
@RequestMapping
public class GoodsController {
    
    @Autowired
    private GoodsService goodsService;
    
    @GetMapping("spu/page")
    public ResponseEntity<PageResult<SpuVo>> pageSpu(@RequestParam(value = "key", required = false) String keyword, @RequestParam(value = "saleable", required = false) Boolean saleable, @RequestParam(value = "page", defaultValue = "1") Integer pageNum, @RequestParam(value = "rows", defaultValue = "5") Integer pageSize) {
        PageResult<SpuVo> spuList = goodsService.pageSpu(keyword, saleable, pageNum, pageSize);
        return ResponseEntity.ok(spuList);
    }
    
    @PostMapping("goods")
    public ResponseEntity<Long> saveGoods(@RequestBody SpuVo spuVo) {
        Long id = goodsService.saveGoods(spuVo);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }
    
    @GetMapping("spu/detail/{spuId}")
    public ResponseEntity<SpuDetail> querySpuDetailBySpuId(@PathVariable(name = "spuId") Long spuId) {
        SpuDetail spuDetail = goodsService.querySpuDetailBySpuId(spuId);
        return ResponseEntity.ok(spuDetail);
    }
    
    @GetMapping("sku/list")
    public ResponseEntity<List<Sku>> querySkuListBySpuId(@RequestParam(name = "id") Long spuId) {
        List<Sku> skus = goodsService.querySkuListBySpuId(spuId);
        return ResponseEntity.ok(skus);
    }
    
}
