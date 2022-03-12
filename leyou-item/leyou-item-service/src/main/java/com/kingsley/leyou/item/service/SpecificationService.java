package com.kingsley.leyou.item.service;

import com.kingsley.leyou.item.domain.SpecGroup;
import com.kingsley.leyou.item.domain.SpecParam;
import com.kingsley.leyou.item.mapper.SpecGroupMapper;
import com.kingsley.leyou.item.mapper.SpecParamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kingsley
 * @time 2022/2/13 20:41
 * @ide IntelliJ IDEA
 * @name com.kingsley.leyou.item.service.SpecificationService
 * @desc 规格接口
 */
@Service
public class SpecificationService {
    
    @Autowired
    private SpecGroupMapper specGroupMapper;
    
    @Autowired
    private SpecParamMapper specParamMapper;
    
    public List<SpecGroup> queryGroupsByCid(Long cid) {
        SpecGroup record = new SpecGroup();
        record.setCid(cid);
        return specGroupMapper.select(record);
    }
    
    public List<SpecParam> queryParamsByGid(Long gid, Long cid, Boolean generic, Boolean searching) {
        SpecParam specParam = new SpecParam();
        specParam.setGroupId(gid);
        specParam.setCid(cid);
        specParam.setGeneric(generic);
        specParam.setSearching(searching);
        return specParamMapper.select(specParam);
    }
}
