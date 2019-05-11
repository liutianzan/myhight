package com.cryptomip.TestSqlServerService;

import com.cryptomip.dao.SAtresultMapper;
import com.cryptomip.pojo.SAtresult;
import com.cryptomip.pojo.SAtresultExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestConnectSqlServiceImlp implements TestConnectSqlServerService {
    @Autowired
    private SAtresultMapper sAtresultMapper;
    @Override
    public SAtresult select(String testId) {
        SAtresultExample example = new SAtresultExample();
        SAtresultExample.Criteria criteria= example.createCriteria();
        criteria.andTestidEqualTo(testId);
        List<SAtresult> list = sAtresultMapper.selectByExample(example);
        if(list.size()!=0)return list.get(0);
        return null;
    }
}
