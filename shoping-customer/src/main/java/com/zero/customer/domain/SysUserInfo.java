package com.zero.customer.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user_info")
public class SysUserInfo {
	
    @Column(name = "USER_ACCOUNT")
    @Id
    private String userAccount;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_NICK")
    private String userNick;

    @Column(name = "WECHAT")
    private String wechat;

    @Column(name = "TEL")
    private String tel;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    /**
     * 0代表启用，1代表禁用
     */
    @Column(name = "IS_ACTIVE")
    private String isActive;

    /**
     * 0代表普通用户，1普通会员，2超级会员
     */
    @Column(name = "USER_TYPE")
    private String userType;

    /**
     * @return USER_ACCOUNT
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * @param userAccount
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    /**
     * @return USER_NAME
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * @return USER_NICK
     */
    public String getUserNick() {
        return userNick;
    }

    /**
     * @param userNick
     */
    public void setUserNick(String userNick) {
        this.userNick = userNick == null ? null : userNick.trim();
    }

    /**
     * @return WECHAT
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * @param wechat
     */
    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    /**
     * @return TEL
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * @return EMAIL
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return ADDRESS
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return BIRTHDAY
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取0代表启用，1代表禁用
     *
     * @return IS_ACTIVE - 0代表启用，1代表禁用
     */
    public String getIsActive() {
        return isActive;
    }

    /**
     * 设置0代表启用，1代表禁用
     *
     * @param isActive 0代表启用，1代表禁用
     */
    public void setIsActive(String isActive) {
        this.isActive = isActive == null ? null : isActive.trim();
    }

    /**
     * 获取0代表普通用户，1普通会员，2超级会员
     *
     * @return USER_TYPE - 0代表普通用户，1普通会员，2超级会员
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置0代表普通用户，1普通会员，2超级会员
     *
     * @param userType 0代表普通用户，1普通会员，2超级会员
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }
}