package com.cryptomip.Differential.trunkDif;

import java.io.IOException;

public interface DifferentTrunkCompileService {
    String saveText(String subText) throws Exception;

    String savePython() throws InterruptedException, IOException;

    void deletePython() throws InterruptedException, IOException;

}
