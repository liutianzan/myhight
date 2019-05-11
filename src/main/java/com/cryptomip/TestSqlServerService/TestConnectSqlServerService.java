package com.cryptomip.TestSqlServerService;

import com.cryptomip.pojo.SAtresult;

public interface TestConnectSqlServerService {
    SAtresult select(String testId);
}
