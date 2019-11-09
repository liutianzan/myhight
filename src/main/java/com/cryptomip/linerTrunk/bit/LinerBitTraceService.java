package com.cryptomip.linerTrunk.bit;

import java.util.HashMap;
import java.util.List;

public interface LinerBitTraceService {
    HashMap<String,String> getTrace(List<String> fileNameList, String solFilePath);
}
