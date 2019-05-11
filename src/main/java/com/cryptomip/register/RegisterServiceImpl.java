package com.cryptomip.register;

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
public class RegisterServiceImpl implements RegisterService {
    //sqlserver
//    @Autowired
//    private UserBaseMapper tuserMapper;


//    @Override
//    public String insertTuser(String username, String password) {
//        //判断用户数据是否正确
//        UserBaseExample example = new UserBaseExample();
//        UserBaseExample.Criteria criteria = example.createCriteria();
//        criteria.andLognameEqualTo(username);
//        List<UserBase> list = tuserMapper.selectByExample(example);
//        if (list.size()!=0){
//            return "用户名已存在";
//        }
//        //进行注册
//        UserBase userBase = new UserBase();
//        userBase.setLogname(username);
//        userBase.setPs(password);
//        tuserMapper.insert(userBase);
//        return "";
//    }

    //本地测试mysql
    @Autowired
    private UserBaseTestMapper testMapper;
    @Override
    public String insertTuser(String username, String password) {
        //判断用户数据是否正确
        UserBaseTestExample example = new UserBaseTestExample();
        UserBaseTestExample.Criteria criteria = example.createCriteria();
        criteria.andLognameEqualTo(username);
        List<UserBaseTest> list = testMapper.selectByExample(example);
        if (list.size()!=0){
            return "用户名已存在";
        }
        //进行注册
        UserBaseTest userBase = new UserBaseTest();
        userBase.setLogname(username);
        userBase.setPs(password);
        testMapper.insert(userBase);
        return "";
    }
}
