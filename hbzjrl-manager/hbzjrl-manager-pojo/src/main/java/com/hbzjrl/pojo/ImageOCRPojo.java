package com.hbzjrl.pojo;

/***
 *Author: Yc
 *Date:2022/5/3 12:58
 *Description:
 */
public class ImageOCRPojo {

        private String Name;//姓名
        private String Sex;//性别
        private String Nation;//民族
        private String Birth;//出生年月
        private String Address;//家庭住址
        private String IdNum;//身份证号
        private String Authority;//身份证反面信息
        private String ValidDate;//身份证反面信息
        private String AdvancedInfo;//身份证反面信息
        private String RequestId;//腾讯云每次请求生成的ID

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getNation() {
        return Nation;
    }

    public void setNation(String nation) {
        Nation = nation;
    }

    public String getBirth() {
        return Birth;
    }

    public void setBirth(String birth) {
        Birth = birth;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getIdNum() {
        return IdNum;
    }

    public void setIdNum(String idNum) {
        IdNum = idNum;
    }

    public String getAuthority() {
        return Authority;
    }

    public void setAuthority(String authority) {
        Authority = authority;
    }

    public String getValidDate() {
        return ValidDate;
    }

    public void setValidDate(String validDate) {
        ValidDate = validDate;
    }

    public String getAdvancedInfo() {
        return AdvancedInfo;
    }

    public void setAdvancedInfo(String advancedInfo) {
        AdvancedInfo = advancedInfo;
    }

    public String getRequestId() {
        return RequestId;
    }

    public void setRequestId(String requestId) {
        RequestId = requestId;
    }

    @Override
    public String toString() {
        return "ImageOCRPojo{" +
                "Name='" + Name + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Nation='" + Nation + '\'' +
                ", Birth='" + Birth + '\'' +
                ", Address='" + Address + '\'' +
                ", IdNum=" + IdNum +
                ", Authority='" + Authority + '\'' +
                ", ValidDate='" + ValidDate + '\'' +
                ", AdvancedInfo='" + AdvancedInfo + '\'' +
                ", RequestId='" + RequestId + '\'' +
                '}';
    }
}
