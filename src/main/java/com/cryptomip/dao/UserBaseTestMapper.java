package com.cryptomip.dao;

import com.cryptomip.pojo.UserBaseTest;
import com.cryptomip.pojo.UserBaseTestExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserBaseTestMapper {
    //mysql数据库测试使用
    long countByExample(UserBaseTestExample example);

    int deleteByExample(UserBaseTestExample example);

    int insert(UserBaseTest record);

    int insertSelective(UserBaseTest record);

    List<UserBaseTest> selectByExample(UserBaseTestExample example);

    int updateByExampleSelective(@Param("record") UserBaseTest record, @Param("example") UserBaseTestExample example);

    int updateByExample(@Param("record") UserBaseTest record, @Param("example") UserBaseTestExample example);
}