package com.li.goodsserver.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.li.goodsserver.model.*;
import com.li.goodsserver.redis.RedisService;
import com.li.goodsserver.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.*;

/**
 * @ClassName GoodsTest
 * @Author lihaodong
 * @Date 2019/1/8 14:50
 * @Mail lihaodongmail@163.com
 * @Description 商品测试
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GoodsTest {

    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private ITypeService typeService;
    @Autowired
    private IBrandService brandService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private IGoodsImgService goodsImgService;
    @Autowired
    private IGoodsSkuService goodsSkuService;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void insertGoods() {
        Goods goods = new Goods();
        goods.setGoodsName("【红五到手价2899】2018年新款 Apple iPad 9.7英寸 128GB WIFI版 平板电脑 MRJP2CH/A 金色");
        goods.setGoodsPrice(BigDecimal.valueOf(3359.00));
        goods.setBrand_id(3);
        // 商品轮播图
        List<String> shows = new ArrayList<>();
        shows.add("http://imgservice.suning.cn/uimg1/b2c/image/oAAOxQ7wPipb72Fzr_7-Uw.jpg_400w_400h_4e_100Q");
        shows.add("//imgservice.suning.cn/uimg1/b2c/image/NqOMXa3zvlRlNkRVnwXWcw.png_800w_800h_4e_100Q");
        shows.add("//imgservice.suning.cn/uimg1/b2c/image/VgsfDZPjVD655B_9Yx3sQw.jpg_800w_800h_4e_100Q");

        String[] arr = shows.toArray(new String[shows.size()]);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("https://shopstatic.vivo.com.cn/vivoshop/commodity/71/4171_1496689409434hd_530x530.png");
        stringBuffer.append("https://shopstatic.vivo.com.cn/vivoshop/commodity/71/4171_1482112378797_530x530.png");
        stringBuffer.append("https://shopstatic.vivo.com.cn/vivoshop/commodity/71/4171_1482112377158_530x530.png");

        // 详情图
        List<String> detailShows = new ArrayList<>();
        detailShows.add("https://image.suning.cn/uimg/sop/commodity/743121293111440080246613_x.jpg?from=mobile");
        detailShows.add("https://image.suning.cn/uimg/sop/commodity/168997727123722687827483_x.jpg?from=mobile");

        goods.setDefaultShow("https://shopstatic.vivo.com.cn/vivoshop/commodity/71/4171_1496689409434hd_530x530.png");
        goods.setDetailsShows(detailShows.toArray(new String[detailShows.size()]).toString());
        boolean save = goodsService.save(goods);
        System.out.println(save);
    }

    @Test
    public void getGoodsBrand() {
        Map<String, Object> goodsClassify = new HashMap<>();


        List<Type> typeList = typeService.list(new QueryWrapper<Type>().lambda().select(Type::getTypeId, Type::getTypeName,Type::getTypeImg));
        typeList.forEach(type -> {

            List<Brand> brandList = brandService.selectBrandByTypeId(new QueryWrapper<Brand>()
                    .lambda()
                    .select(Brand::getBrandId, Brand::getBrandName, Brand::getBrandImg)
                    .eq(Brand::getTypeId, type.getTypeId()));

            redisTemplate.opsForHash().put("brand","type_"+type.getTypeId(),brandList);
        });
        redisTemplate.opsForHash().put("brand","type",typeList);
        redisTemplate.opsForHash().put("brand","type_0",typeList);

        Object o = redisTemplate.opsForHash().get("brand", "type");
        System.out.println(JSON.toJSONString(o));

    }

    @Test
    public void remove() {
        System.out.println(redisService.removeKey("goodsClassify"));
    }

    @Test
    public void getGoods(){

        Map<String,Object> map = new HashMap<>();
        Goods byId = goodsService.getById(7);

        List<GoodsImg> goodsImgs = goodsImgService.selectGoodsImgByGoodsId(7);
        List<GoodsSku> goodsSkus = goodsSkuService.selectGoodsSkuByGoodsId(7);

        map.put("goods",byId);
        map.put("goodsImg",goodsImgs);
        map.put("goodsSku",goodsSkus);
        System.out.println(JSON.toJSONString(map));

    }

    public static void main(String[] args) {
        List<String> qq = new ArrayList<>();
        qq.add("1");
        qq.add("2");

        String[] str = {"a", "b", "c"};

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < str.length;i++){
            sb.append(str[i]);

        }

        System.out.println(qq);
        System.out.println(Arrays.toString(str));


    }

}
