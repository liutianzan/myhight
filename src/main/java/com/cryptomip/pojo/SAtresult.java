package com.cryptomip.pojo;

import java.util.Date;

public class SAtresult {
    private String algoname;

    private String testid;

    private Date stime;

    private Date etime;

    private String comtime;

    private String attacktype;

    private String attackmode;

    private Integer round;

    private String attackpara;

    private String testresult1;

    private String testresult2;

    private String memo1;

    private String memo2;

    public String getAlgoname() {
        return algoname;
    }

    public void setAlgoname(String algoname) {
        this.algoname = algoname;
    }

    public String getTestid() {
        return testid;
    }

    public void setTestid(String testid) {
        this.testid = testid;
    }

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    public Date getEtime() {
        return etime;
    }

    public void setEtime(Date etime) {
        this.etime = etime;
    }

    public String getComtime() {
        return comtime;
    }

    public void setComtime(String comtime) {
        this.comtime = comtime;
    }

    public String getAttacktype() {
        return attacktype;
    }

    public void setAttacktype(String attacktype) {
        this.attacktype = attacktype;
    }

    public String getAttackmode() {
        return attackmode;
    }

    public void setAttackmode(String attackmode) {
        this.attackmode = attackmode;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public String getAttackpara() {
        return attackpara;
    }

    public void setAttackpara(String attackpara) {
        this.attackpara = attackpara;
    }

    public String getTestresult1() {
        return testresult1;
    }

    public void setTestresult1(String testresult1) {
        this.testresult1 = testresult1;
    }

    public String getTestresult2() {
        return testresult2;
    }

    public void setTestresult2(String testresult2) {
        this.testresult2 = testresult2;
    }

    public String getMemo1() {
        return memo1;
    }

    public void setMemo1(String memo1) {
        this.memo1 = memo1;
    }

    public String getMemo2() {
        return memo2;
    }

    public void setMemo2(String memo2) {
        this.memo2 = memo2;
    }

    @Override
    public String toString() {
        return "SAtresult{" +
                "algoname='" + algoname + '\'' +
                ", testid='" + testid + '\'' +
                ", stime=" + stime +
                ", etime=" + etime +
                ", comtime='" + comtime + '\'' +
                ", attacktype='" + attacktype + '\'' +
                ", attackmode='" + attackmode + '\'' +
                ", round=" + round +
                ", attackpara='" + attackpara + '\'' +
                ", testresult1='" + testresult1 + '\'' +
                ", testresult2='" + testresult2 + '\'' +
                ", memo1='" + memo1 + '\'' +
                ", memo2='" + memo2 + '\'' +
                '}';
    }
}