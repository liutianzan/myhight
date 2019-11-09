package com.cryptomip.login;

import com.cryptomip.dao.UserBaseMapper;
import com.cryptomip.dao.UserBaseTestMapper;
import com.cryptomip.pojo.UserBase;
import com.cryptomip.pojo.UserBaseExample;
import com.cryptomip.pojo.UserBaseTest;
import com.cryptomip.pojo.UserBaseTestExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    //sqlserver数据库
    @Autowired
    private UserBaseMapper userBaseMapper;
    @Override
    public String isLogin(String username, String password) {
        UserBaseExample example = new UserBaseExample();
        UserBaseExample.Criteria criteria = example.createCriteria();
        criteria.andLognameEqualTo(username);
        List<UserBase> list = userBaseMapper.selectByExample(example);
        if(list.size()==0){
            return "用户名不存在";
        }
        criteria.andPsEqualTo(password);

        if(userBaseMapper.selectByExample(example).size()==0){
            return "用户名或密码错误";
        }
        return "";
    }
    //本地mysql
//    @Autowired
//    private UserBaseTestMapper userBaseTestMapper;
//    @Override
//    public String isLogin(String username, String password) {
//        UserBaseTestExample example = new UserBaseTestExample();
//        UserBaseTestExample.Criteria criteria = example.createCriteria();
//        criteria.andLognameEqualTo(username);
//        List<UserBaseTest> list = userBaseTestMapper.selectByExample(example);
//        if(list.size()==0){
//            return "用户名不存在";
//        }
//        criteria.andPsEqualTo(password);
//
//        if(userBaseTestMapper.selectByExample(example).size()==0){
//            return "用户名或密码错误";
//        }
//        return "";
//    }
}
