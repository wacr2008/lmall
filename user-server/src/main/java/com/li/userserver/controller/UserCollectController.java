package com.li.userserver.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.li.userserver.bo.RestResponseBo;
import com.li.userserver.model.UserCollect;
import com.li.userserver.service.IUserCollectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-21
 */
@Slf4j
@RestController
@RequestMapping("user-collect")
public class UserCollectController {

    @Autowired
    private IUserCollectService userCollectService;

    /**
     * 添加收藏
     * @param userCollect
     * @param request
     * @return
     */
    @RequestMapping("/insert")
    public RestResponseBo insert(UserCollect userCollect, HttpServletRequest request){

        int userId = (int) request.getSession().getAttribute("userId");
        userCollect.setUserId(userId);
        userCollectService.save(userCollect);
        return RestResponseBo.ok();
    }

    @RequestMapping("/delete")
    public RestResponseBo cancelCollect(int goodsId,HttpServletRequest request){
        int userId = (int) request.getSession().getAttribute("userId");
        boolean remove = userCollectService.deleteCollectByGoodsId(goodsId,userId);
        return RestResponseBo.ok();
    }

    @RequestMapping("/isExits")
    public RestResponseBo isExits(int goodsId,HttpServletRequest request){
        int userId = (int) request.getSession().getAttribute("userId");
        boolean exitsGoods = userCollectService.isExitsGoods(goodsId,userId);
        if (exitsGoods){
            return RestResponseBo.ok();
        } else {
            return RestResponseBo.fail();
        }
    }

    @RequestMapping("/selectGoods")
    public RestResponseBo selectGoods(int page,int pageSize,HttpServletRequest request){
        try {
            int userId = (int) request.getSession().getAttribute("userId");
            IPage<UserCollect> userCollectIPage = userCollectService.selectGoodsByPage(userId, page, pageSize);
            long pages = userCollectIPage.getPages();
            List<UserCollect> collectList = userCollectIPage.getRecords();
            Map<String, Object> map = new HashMap<>();
            map.put("collectList", collectList);
            map.put("pages", pages);
            return RestResponseBo.ok(map,100);
        } catch (Exception e){
            log.error("用户查询商品收藏失败,{}",e.getMessage());
            return RestResponseBo.fail(101,"服务器在偷懒哦");
        }

    }
}

