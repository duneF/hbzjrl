package com.hbzjrl.pojo;

import com.fasterxml.jackson.databind.node.BigIntegerNode;

import java.math.BigInteger;
import java.sql.Date;

/***
 *@Author: Yc
 *@Date:2022/4/12 9:53
 *@Description:
 */
public class YgPojo {
    private Integer user_id;
    private String whereHome;
    private String name;
    private String sex;
    private Integer age;
    private BigInteger sfNumber;
    private BigInteger phone;
    private Date goTime;
    private String address;
    private String factory;
    private String workTime;
    private String byCar;
    private Double workerPrice;
    private Double workerCarPrice;
    private String wokerRemarks;
    private String whose;
    private Double whosePrice;
    private String whoseRemarks;
    private Double totalPrice;
    private Date createTime;
    private Date update;
    private  Integer pageNum;
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getWhereHome() {
        return whereHome;
    }

    public void setWhereHome(String whereHome) {
        this.whereHome = whereHome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigInteger getSfNumber() {
        return sfNumber;
    }

    public void setSfNumber(BigInteger sfNumber) {
        this.sfNumber = sfNumber;
    }

    public BigInteger getPhone() {
        return phone;
    }

    public void setPhone(BigInteger phone) {
        this.phone = phone;
    }

    public Date getGoTime() {
        return goTime;
    }

    public void setGoTime(Date goTime) {
        this.goTime = goTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getByCar() {
        return byCar;
    }

    public void setByCar(String byCar) {
        this.byCar = byCar;
    }

    public Double getWorkerPrice() {
        return workerPrice;
    }

    public void setWorkerPrice(Double workerPrice) {
        this.workerPrice = workerPrice;
    }

    public Double getWorkerCarPrice() {
        return workerCarPrice;
    }

    public void setWorkerCarPrice(Double workerCarPrice) {
        this.workerCarPrice = workerCarPrice;
    }

    public String getWokerRemarks() {
        return wokerRemarks;
    }

    public void setWokerRemarks(String wokerRemarks) {
        this.wokerRemarks = wokerRemarks;
    }

    public String getWhose() {
        return whose;
    }

    public void setWhose(String whose) {
        this.whose = whose;
    }

    public Double getWhosePrice() {
        return whosePrice;
    }

    public void setWhosePrice(Double whosePrice) {
        this.whosePrice = whosePrice;
    }

    public String getWhoseRemarks() {
        return whoseRemarks;
    }

    public void setWhoseRemarks(String whoseRemarks) {
        this.whoseRemarks = whoseRemarks;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    @Override
    public String toString() {
        return "YgPojo{" +
                "user_id=" + user_id +
                ", whereHome='" + whereHome + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", sfNumber=" + sfNumber +
                ", phone=" + phone +
                ", goTime=" + goTime +
                ", address='" + address + '\'' +
                ", factory='" + factory + '\'' +
                ", workTime='" + workTime + '\'' +
                ", byCar='" + byCar + '\'' +
                ", workerPrice=" + workerPrice +
                ", workerCarPrice=" + workerCarPrice +
                ", wokerRemarks='" + wokerRemarks + '\'' +
                ", whose='" + whose + '\'' +
                ", whosePrice=" + whosePrice +
                ", whoseRemarks='" + whoseRemarks + '\'' +
                ", totalPrice=" + totalPrice +
                ", createTime=" + createTime +
                ", update=" + update +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
