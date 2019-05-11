package com.cryptomip.dao;

import com.cryptomip.pojo.UserBase;
import com.cryptomip.pojo.UserBaseExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserBaseMapper {
    long countByExample(UserBaseExample example);

    int deleteByExample(UserBaseExample example);

    int insert(UserBase record);

    int insertSelective(UserBase record);

    List<UserBase> selectByExample(UserBaseExample example);

    int updateByExampleSelective(@Param("record") UserBase record, @Param("example") UserBaseExample example);

    int updateByExample(@Param("record") UserBase record, @Param("example") UserBaseExample example);
}