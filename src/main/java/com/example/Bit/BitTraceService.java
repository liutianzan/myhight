package com.example.Bit;

import java.util.HashMap;
import java.util.List;

public interface BitTraceService {
    HashMap<String,String> getTrace(List<String> fileNameList,String solFilePath);
}
