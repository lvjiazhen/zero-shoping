package com.zero.order.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "order_summary")
public class OrderSummary {
    @Column(name = "UUID")
    private String uuid;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "ORDER_TM")
    private Date orderTm;

    @Column(name = "TOTAL_MONEY")
    private Float totalMoney;

    @Column(name = "SAVE_MONEY")
    private Float saveMoney;

    @Column(name = "STATE")
    private Short state;

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
     * @return ORDER_TM
     */
    public Date getOrderTm() {
        return orderTm;
    }

    /**
     * @param orderTm
     */
    public void setOrderTm(Date orderTm) {
        this.orderTm = orderTm;
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

    /**
     * @return STATE
     */
    public Short getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Short state) {
        this.state = state;
    }
}