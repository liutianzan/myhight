package com.cryptomip.pojo;

public class UserBaseTest {
    private String logname;

    private String username;

    private String ps;

    private String type;

    public String getLogname() {
        return logname;
    }

    public void setLogname(String logname) {
        this.logname = logname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "UserBaseTest{" +
                "logname='" + logname + '\'' +
                ", username='" + username + '\'' +
                ", ps='" + ps + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}