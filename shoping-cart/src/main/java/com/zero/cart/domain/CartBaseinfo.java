package com.zero.cart.domain;

import javax.persistence.*;

@Table(name = "cart_baseinfo")
public class CartBaseinfo {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "UUID")
    private String uuid;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "GOODS_ID")
    private String goodsId;

    @Column(name = "BUY_NUM")
    private Integer buyNum;

    /**
     * @return UUID
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * @return USER_ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * @return GOODS_ID
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /**
     * @return BUY_NUM
     */
    public Integer getBuyNum() {
        return buyNum;
    }

    /**
     * @param buyNum
     */
    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }
}