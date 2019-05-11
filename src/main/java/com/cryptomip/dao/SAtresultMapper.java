package com.cryptomip.dao;

import com.cryptomip.pojo.SAtresult;
import com.cryptomip.pojo.SAtresultExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SAtresultMapper {
    long countByExample(SAtresultExample example);

    int deleteByExample(SAtresultExample example);

    int insert(SAtresult record);

    int insertSelective(SAtresult record);

    List<SAtresult> selectByExample(SAtresultExample example);

    int updateByExampleSelective(@Param("record") SAtresult record, @Param("example") SAtresultExample example);

    int updateByExample(@Param("record") SAtresult record, @Param("example") SAtresultExample example);
}