package com.hc.common.pojo;

import java.io.Serializable;
import java.util.Date;


public class User implements Serializable {
    private Integer id;

    private String uuid;

    private String account;

    private String password;

    private String nickname;

    private Byte sex;

    private Integer age;

    private String phone;

    private Date createtime;

    private Date updatetime;

    private Byte status;

    private Byte deletestatus;
    public User(){}

    public User(Integer id, String uuid, String account, String password, String nickname, Byte sex, Integer age, String phone, Date createtime, Date updatetime, Byte status, Byte deletestatus) {
        super();
        this.id = id;
        this.uuid = uuid;
        this.account = account;
        this.password = password;
        this.nickname = nickname;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.status = status;
        this.deletestatus = deletestatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", status=" + status +
                ", deletestatus=" + deletestatus +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(Byte deletestatus) {
        this.deletestatus = deletestatus;
    }
}