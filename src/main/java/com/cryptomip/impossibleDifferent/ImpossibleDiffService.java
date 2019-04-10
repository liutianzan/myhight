package com.cryptomip.impossibleDifferent;

import java.io.IOException;

public interface ImpossibleDiffService {
    String saveText(String subText) throws Exception;
    String savePython() throws InterruptedException, IOException;
    void deletePython() throws InterruptedException, IOException;
    void removeSolFile() throws InterruptedException, IOException;
    String complieProject() throws Exception;
    String compilePython() throws InterruptedException, IOException;
    String getCompileContent();
}