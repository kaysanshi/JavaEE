package com.kayleoi.springbootshop.domain;

import javax.persistence.*;

//@Table(name = "spring-boot-shop..banner")
@Table(name = "banner")
public class Banner {
    @Id
    private String id;

    private String title;

    private String image;

    private String create;

    private String productid;

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
    public String getCreate() {
        return create;
    }

    /**
     * @param create
     */
    public void setCreate(String create) {
        this.create = create;
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