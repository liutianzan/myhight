package com.cryptomip.ZeroRelated.Trunk;

import java.io.IOException;

public interface ZcTrunkService {
    String saveText(String subText) throws Exception;
    String savePython() throws InterruptedException, IOException;
    void deletePython() throws InterruptedException, IOException;
    void removeSolFile() throws InterruptedException, IOException;
    void complieProject() throws Exception;
    void compilePython() throws InterruptedException, IOException;
    String getCompileContent();
}
