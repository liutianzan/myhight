package com.cryptomip.Differential.trunkDif;

import java.io.IOException;

public interface DifferentTrunkAnalysisService {
    void complieProject(String userName) throws Exception;

    void compilePython(String userName) throws InterruptedException, IOException;

    String getAnalysisContent();
}
