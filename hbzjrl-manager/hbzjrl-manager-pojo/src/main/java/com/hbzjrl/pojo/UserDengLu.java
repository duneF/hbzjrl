package com.hbzjrl.pojo;

/***
 *@Author: Yc
 *@Date:2022/4/520:00
 *@Description:
 */
public class UserDengLu {
    private String userName;
    private Integer passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPassWord() {
        return passWord;
    }

    public void setPassWord(Integer passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "UserDengLU{" +
                "userName='" + userName + '\'' +
                ", passWord=" + passWord +
                '}';
    }
}
