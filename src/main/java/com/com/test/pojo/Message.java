package com.com.test.pojo;

import java.util.List;
import java.util.Map;

public class Message {
    public String code;
    public int total;
    public Object date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date=date;
    }

    public static Message success(Object date){
        Message success = new Message();
        success.date=date;
        success.total = 0;
        success.code = "200";
        return success;
    }
    public static Message fail(String code){
        Message fail = new Message();
        fail.code = code;
        return fail;
    }
    public static Message customize(String code,Object date){
        Message customized = new Message();
        customized.code = code;
        customized.date = date;
        return customized;
    }
}
