package com.kaysanshi.springbootshop.service.impl;

import com.kaysanshi.springbootshop.dao.BannerMapper;
import com.kaysanshi.springbootshop.domain.Banner;
import com.kaysanshi.springbootshop.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @Author kay三石
 * @date:2019/12/15
 */
@Controller
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerMapper bannerMapper;

    @Override
    public List<Banner> getlistByPosition() {
        return bannerMapper.selectAll();
    }

    @Override
    public Banner save(Banner banner) {
        if (bannerMapper.insert(banner)>0){
           return bannerMapper.selectOne(banner);
        }else {
            return null;
        }
    }

    @Override
    public Banner update(Banner banner) {
        if (bannerMapper.updateByPrimaryKey(banner)>0){
            return bannerMapper.selectOne(banner);
        }else {
            return null;
        }
    }

    @Override
    public int delete(Banner banner) {
        return bannerMapper.delete(banner);
    }
}
