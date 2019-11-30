package com.kaysanshi.springbootshop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author kay三石
 * @date:2019/11/25
 */
@Component
public class UploadConfig {

    @Value("${upload.path.product.img}")
    private String pimgPath;
    @Value("${server.port}")
    private String port;


    public String getPimgPath() {
        return pimgPath;
    }

    public void setPimgPath(String pimgPath) {
        this.pimgPath = pimgPath;
    }


    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}