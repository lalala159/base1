package com.hc.common.pojo;

import java.io.Serializable;

public class Account  implements Serializable {
    private Integer id;

    private String applyer;

    private String applyDate;

    private Double money;

    private String yt;

    private String shman;

    private String shDate;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplyer() {
        return applyer;
    }

    public void setApplyer(String applyer) {
        this.applyer = applyer;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getYt() {
        return yt;
    }

    public void setYt(String yt) {
        this.yt = yt;
    }

    public String getShman() {
        return shman;
    }

    public void setShman(String shman) {
        this.shman = shman;
    }

    public String getShDate() {
        return shDate;
    }

    public void setShDate(String shDate) {
        this.shDate = shDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}