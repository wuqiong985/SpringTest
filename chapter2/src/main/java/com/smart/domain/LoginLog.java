package com.smart.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wuqiong6 on 2018/2/28.
 */
public class LoginLog implements Serializable {

    private static final long serialVersionUID = -157376297006181514L;

    private int loginLogId;

    /**
     * 登陆用户Id
     */
    private int userId;

    /**
     * 登陆Ip
     */
    private String ip;

    /**
     * 登陆时间
     */
    private Date loginTime;

    public int getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
