package com.kaysanshi.springbootshop.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "product")
public class Product {
    @Id
    private String id;

    private String name;

    @Column(name = "market_price")
    private Double marketPrice;

    @Column(name = "shop_price")
    private Double shopPrice;

    private String image;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date date;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @Column(name = "create_time")
    private Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @Column(name = "update_time")
    private Date updateTime;


    /**
     * 是否最热 0->最热； 1->不是
     */
    @Column(name = "is_hot")
    private Integer isHot;

    /**
     * 详细标题
     */
    @Column(name = "detail_title")
    private String detailTitle;

    private Integer flag;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 删除状态：0->未删除；1->已删除
     */
    @Column(name = "delete_status")
    private Integer deleteStatus;

    /**
     * 上架状态：0->下架；1->上架
     */
    @Column(name = "publish_status")
    private Integer publishStatus;

    /**
     * 新品状态:0->不是新品；1->新品
     */
    @Column(name = "new_status")
    private Integer newStatus;

    /**
     * 推荐状态；0->不推荐；1->推荐
     */
    @Column(name = "recommand_status")
    private Integer recommandStatus;

    private String note;

    private String cid;

    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

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

    @Column(name = "createuser")
    public String createUser;

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 描述页
     */
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return market_price
     */
    public Double getMarketPrice() {
        return marketPrice;
    }

    /**
     * @param marketPrice
     */
    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * @return shop_price
     */
    public Double getShopPrice() {
        return shopPrice;
    }

    /**
     * @param shopPrice
     */
    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
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
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 获取是否最热 0->最热； 1->不是
     *
     * @return is_hot - 是否最热 0->最热； 1->不是
     */
    public Integer getIsHot() {
        return isHot;
    }

    /**
     * 设置是否最热 0->最热； 1->不是
     *
     * @param isHot 是否最热 0->最热； 1->不是
     */
    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    /**
     * 获取详细标题
     *
     * @return detail_title - 详细标题
     */
    public String getDetailTitle() {
        return detailTitle;
    }

    /**
     * 设置详细标题
     *
     * @param detailTitle 详细标题
     */
    public void setDetailTitle(String detailTitle) {
        this.detailTitle = detailTitle;
    }

    /**
     * @return flag
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * @param flag
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /**
     * 获取库存
     *
     * @return stock - 库存
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置库存
     *
     * @param stock 库存
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取删除状态：0->未删除；1->已删除
     *
     * @return delete_status - 删除状态：0->未删除；1->已删除
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 设置删除状态：0->未删除；1->已删除
     *
     * @param deleteStatus 删除状态：0->未删除；1->已删除
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * 获取上架状态：0->下架；1->上架
     *
     * @return publish_status - 上架状态：0->下架；1->上架
     */
    public Integer getPublishStatus() {
        return publishStatus;
    }

    /**
     * 设置上架状态：0->下架；1->上架
     *
     * @param publishStatus 上架状态：0->下架；1->上架
     */
    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    /**
     * 获取新品状态:0->不是新品；1->新品
     *
     * @return new_status - 新品状态:0->不是新品；1->新品
     */
    public Integer getNewStatus() {
        return newStatus;
    }

    /**
     * 设置新品状态:0->不是新品；1->新品
     *
     * @param newStatus 新品状态:0->不是新品；1->新品
     */
    public void setNewStatus(Integer newStatus) {
        this.newStatus = newStatus;
    }

    /**
     * 获取推荐状态；0->不推荐；1->推荐
     *
     * @return recommand_status - 推荐状态；0->不推荐；1->推荐
     */
    public Integer getRecommandStatus() {
        return recommandStatus;
    }

    /**
     * 设置推荐状态；0->不推荐；1->推荐
     *
     * @param recommandStatus 推荐状态；0->不推荐；1->推荐
     */
    public void setRecommandStatus(Integer recommandStatus) {
        this.recommandStatus = recommandStatus;
    }

    /**
     * @return note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid
     */
    public void setCid(String cid) {
        this.cid = cid;
    }

}