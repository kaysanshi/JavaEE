package com.kaysanshi.springbootshop.controller;

import com.kaysanshi.springbootshop.domain.Banner;
import com.kaysanshi.springbootshop.dto.BaseResult;
import com.kaysanshi.springbootshop.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 轮播
 * @Author kay三石
 * @date:2019/12/15
 */
@Controller
public class BannerController {
    @Autowired
    private BannerService bannerService;

    /**
     *list
     * @return
     */
    @RequestMapping("/banner/list")
    @ResponseBody
    public BaseResult getBannerList(){
        List<Banner> list1=bannerService.getlistByPosition();
        return BaseResult.success(list1);
    }
    /**
     *轮播图添加
     * @param banner
     * @return
     */
    @RequestMapping("/banner/add")
    @ResponseBody
    public  BaseResult uploadBanner(Banner banner){
        if (banner.getImage()!=null){
            banner.setId( UUID.randomUUID().toString());
            banner.setCreateTime(new Date());
            Banner banner1=bannerService.save(banner);
            if (banner!=null){
                return BaseResult.success(banner1);
            }else{
                return BaseResult.error();
            }
        }else{
            return BaseResult.error();
        }
    }

    /**
     *
     * @param banner
     * @return
     */
    @RequestMapping("/banner/update")
    @ResponseBody
    public BaseResult updateBanner(Banner banner){
        if (banner.getId()!=null){
            banner.setId( UUID.randomUUID().toString());
            Banner banner1=bannerService.update(banner);
            if (banner!=null){
                return BaseResult.success(banner1);
            }else{
                return BaseResult.error();
            }
        }else{
            return BaseResult.error("id不可以为null");
        }
    }

    /**
     *
     * @param banner
     * @return
     */
    @RequestMapping("/banner/delete")
    @ResponseBody
    public  BaseResult deleteBanner(Banner banner) {
        if (banner.getId() != null) {
            int banner1 = bannerService.delete(banner);
            if (banner1 > 0) {
                return BaseResult.success(banner1);
            }else{
                return BaseResult.error();
            }
        }else{
            return BaseResult.error("id不可以为null");
        }
    }
}
