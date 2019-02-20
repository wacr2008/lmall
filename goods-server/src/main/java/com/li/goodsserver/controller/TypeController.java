package com.li.goodsserver.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.li.goodsserver.bo.RestResponseBo;
import com.li.goodsserver.model.Type;
import com.li.goodsserver.service.ITypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-07
 */
@Slf4j
@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private ITypeService typeService;

    @RequestMapping("/insert")
    public RestResponseBo insetType(Type type){
        try {
            typeService.save(type);
            return RestResponseBo.ok();
        } catch (Exception e){
            log.error("添加类型信息失败,原因{}",e.getMessage());
            return RestResponseBo.fail(300,"添加类型信息失败");
        }

    }

    @RequestMapping("/selectTypeList")
    public RestResponseBo selectTypeList(){
        try {
            List<Type> list = typeService.list(null);
            return RestResponseBo.ok(list,000);
        } catch (Exception e){
            log.error("查询类型信息失败,原因{}",e.getMessage());
            return RestResponseBo.fail(300,"查询类型信息失败");
        }

    }

    @RequestMapping("/remove")
    public RestResponseBo removeType(int id){
        try {
            typeService.removeById(id);
            return RestResponseBo.ok();
        } catch (Exception e){
            log.error("删除类型信息失败,原因{}",e.getMessage());
            return RestResponseBo.fail(300,"删除类型信息失败");
        }

    }


}

