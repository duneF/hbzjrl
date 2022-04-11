package com.hbzjrl.pojo;

import javax.xml.crypto.Data;
import java.sql.Date;

/***
 *@Author: Yc
 *@Date:2022/4/520:00
 *@Description:
 */
public class UserDengLu {
    private String username;
    private String password;
    private String radioname;
    private Integer login_id;
    private String name;
    private Integer tel;
    private String address;
    private Integer age;
    private Integer sex;
    private Data birthday;
    private Date created;
    private Date updated;


    public String getRadioname() {
        return radioname;
    }

    public void setRadioname(String radioname) {
        this.radioname = radioname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLogin_id() {
        return login_id;
    }

    public void setLogin_id(Integer login_id) {
        this.login_id = login_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Data getBirthday() {
        return birthday;
    }

    public void setBirthday(Data birthday) {
        this.birthday = birthday;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "UserDengLu{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", radioname='" + radioname + '\'' +
                ", login_id=" + login_id +
                ", name='" + name + '\'' +
                ", tel=" + tel +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
