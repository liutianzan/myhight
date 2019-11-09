package com.cryptomip.linerTrunk.trunk;

import java.util.HashMap;
import java.util.List;

public interface LinerTrunkTraceService {
    HashMap<String,String> getTrace(List<String> fileNameList,String solFilePath);
}
