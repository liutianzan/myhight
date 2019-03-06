package com.example;

import java.util.HashMap;
import java.util.List;

public interface TraceService {
    public HashMap<String,String> getTrace(List<String> fileNameList);
}
