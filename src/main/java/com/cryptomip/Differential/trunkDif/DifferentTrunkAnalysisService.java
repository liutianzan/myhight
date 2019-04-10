package com.cryptomip.Differential.trunkDif;

import java.io.IOException;

public interface DifferentTrunkAnalysisService {
    void complieProject() throws Exception;

    void compilePython() throws InterruptedException, IOException;

    String getAnalysisContent();
}
