package com.cryptomip.TestSqlServerService;

import com.baseTool.util.UUidUtil;
import com.cryptomip.pojo.SAtresult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestConnectSqlService {
    @Autowired
    private TestConnectSqlServerService testConnectSqlServerService;
    @RequestMapping("selectSql")
    @ResponseBody
    public String selectSqlServer(String testid){
        SAtresult sAtresult = testConnectSqlServerService.select(testid);
        return sAtresult.toString();
    }
}
