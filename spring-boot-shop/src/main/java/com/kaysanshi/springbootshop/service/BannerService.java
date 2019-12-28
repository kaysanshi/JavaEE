package com.kaysanshi.springbootshop.service;

import com.kaysanshi.springbootshop.domain.Banner;

import java.util.List;

/**
 * @Author kay三石
 * @date:2019/12/15
 */
public interface BannerService {

    List<Banner> getlistByPosition();

    Banner save(Banner banner);

    Banner update(Banner banner);

    int delete(Banner banner);
}
