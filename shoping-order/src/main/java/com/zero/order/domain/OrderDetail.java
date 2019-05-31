package com.zero.order.domain;

import javax.persistence.*;

@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "UUID")
    private String uuid;

    @Column(name = "ORDER_UUID")
    private Integer orderUuid;

    @Column(name = "GOODS_UUID")
    private Integer goodsUuid;

    @Column(name = "ORDER_NUM")
    private Integer orderNum;

    @Column(name = "PRICE")
    private Float price;

    @Column(name = "TOTAL_MONEY")
    private Float totalMoney;

    @Column(name = "SAVE_MONEY")
    private Float saveMoney;

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
     * @return ORDER_UUID
     */
    public Integer getOrderUuid() {
        return orderUuid;
    }

    /**
     * @param orderUuid
     */
    public void setOrderUuid(Integer orderUuid) {
        this.orderUuid = orderUuid;
    }

    /**
     * @return GOODS_UUID
     */
    public Integer getGoodsUuid() {
        return goodsUuid;
    }

    /**
     * @param goodsUuid
     */
    public void setGoodsUuid(Integer goodsUuid) {
        this.goodsUuid = goodsUuid;
    }

    /**
     * @return ORDER_NUM
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * @param orderNum
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * @return PRICE
     */
    public Float getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * @return TOTAL_MONEY
     */
    public Float getTotalMoney() {
        return totalMoney;
    }

    /**
     * @param totalMoney
     */
    public void setTotalMoney(Float totalMoney) {
        this.totalMoney = totalMoney;
    }

    /**
     * @return SAVE_MONEY
     */
    public Float getSaveMoney() {
        return saveMoney;
    }

    /**
     * @param saveMoney
     */
    public void setSaveMoney(Float saveMoney) {
        this.saveMoney = saveMoney;
    }
}