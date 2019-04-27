package com.cryptomip.Differential.trunkDif;

import java.io.IOException;

public interface DifferentTrunkCompileService {
    String saveText(String subText,String userName) throws Exception;

    String savePython(String userName) throws InterruptedException, IOException;

    void deletePython(String userName) throws InterruptedException, IOException;

}
