package com.kaysanshi.springbootshop.dto;

import com.kaysanshi.springbootshop.domain.Product;

/**
 * @Author kay三石
 * @date:2019/11/27
 */
public class CartItem {
    private Product product;
    private int buyNum;
    private double subtotal;

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getBuyNum() {
        return buyNum;
    }
    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
