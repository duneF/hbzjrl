package com.hbzjrl.pojo;

/***
 *@Author: Yc
 *@Date:2022/4/520:00
 *@Description:
 */
public class UserDengLu {
    private String username;
    private Integer password;
    private String radioname;

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

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDengLu{" +
                "username='" + username + '\'' +
                ", password=" + password +
                ", radioname='" + radioname + '\'' +
                '}';
    }
}
