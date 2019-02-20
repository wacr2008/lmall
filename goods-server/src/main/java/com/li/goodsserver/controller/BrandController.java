package com.li.goodsserver.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.li.goodsserver.bo.RestResponseBo;
import com.li.goodsserver.model.Brand;
import com.li.goodsserver.redis.RedisService;
import com.li.goodsserver.service.IBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-08
 */
@Slf4j
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private IBrandService brandService;
    @Autowired
    private RedisService redisService;

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/selectByTypeId")
    public RestResponseBo selectByTypeId(int typeId){
        try {
            QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
            queryWrapper.select("brandId","brandName");
            queryWrapper.lambda().eq(Brand::getTypeId,typeId);
            List<Brand> list = brandService.selectBrandByTypeId(queryWrapper);
            return RestResponseBo.ok(list,000);
        } catch (Exception e){
            log.error("类型查询品牌信息失败,原因{}",e.getMessage());
            return RestResponseBo.fail(300,"查询品牌信息失败");
        }
    }

    @RequestMapping("/insert")
    public RestResponseBo insert(Brand brand){
        try {
            brandService.save(brand);
            return RestResponseBo.ok();
        } catch (Exception e){
            log.error("添加品牌信息失败,原因{}",e.getMessage());
            return RestResponseBo.fail(300,"添加品牌信息失败");
        }
    }


    @RequestMapping("/getAllBrand")
    public RestResponseBo getAllBrand(){
//        List<Map<String, Object>> goodsClassify1= (List<Map<String, Object>>) redisService.getValue("goodsClassify");
//        if (goodsClassify1 != null){
//            return RestResponseBo.ok(goodsClassify1,000);
//        }
//        List<Map<String, Object>> goodsClassify = brandService.goodsClassify();
//        redisService.save("goodsClassify",goodsClassify);
        Object o = redisTemplate.opsForHash().get("brand", "type");
        Object brandList = redisService.getBrandList("brand", "type_1");
        Map<String,Object> map = new HashMap<>();
        map.put("type",o);
        map.put("brand",brandList);
        return RestResponseBo.ok(map,000);
    }


    @RequestMapping("/getBrandByTypeId")
    public RestResponseBo getBrandByTypeId(int typeId){
        Object brandList = redisService.getBrandList("brand", "type_" + typeId);
        return RestResponseBo.ok(brandList,000);
    }



}

