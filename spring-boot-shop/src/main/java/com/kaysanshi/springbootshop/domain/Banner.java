package com.kaysanshi.springbootshop.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

//@Table(name = "spring-boot-shop..banner")
@Table(name = "banner")
public class Banner {
    @Id
    private String id;

    private String title;

    private String image;

    private String createuser;

    private String productid;


    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    @Column(name = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return create
     */
    public String getCreateUse() {
        return createuser;
    }

    /**
     * @param create
     */
    public void setCreateUser(String create) {
        this.createuser = create;
    }

    /**
     * @return productid
     */
    public String getProductid() {
        return productid;
    }

    /**
     * @param productid
     */
    public void setProductid(String productid) {
        this.productid = productid;
    }
}