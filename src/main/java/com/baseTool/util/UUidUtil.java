package com.baseTool.util;

import java.util.UUID;

public class UUidUtil {
    public static String getUUID32(){
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
//  return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
}
