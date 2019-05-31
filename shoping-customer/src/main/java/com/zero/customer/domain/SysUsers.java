package com.zero.customer.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_users")
public class SysUsers {
    @Id
  //  @GeneratedValue(generator = "UUID")
    @Column(name = "USER_ACCOUNT")
    private String userAccount;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "LAST_LOGIN")
    private Date lastLogin;

    @Column(name = "LOGIN_IP")
    private String loginIp;

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
     * @return PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return LAST_LOGIN
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * @param lastLogin
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * @return LOGIN_IP
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * @param loginIp
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }
}