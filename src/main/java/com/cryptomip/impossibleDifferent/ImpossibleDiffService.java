package com.cryptomip.impossibleDifferent;

import java.io.IOException;

public interface ImpossibleDiffService {
    String saveText(String subText,String userName) throws Exception;
    String savePython(String userName) throws InterruptedException, IOException;
    void deletePython(String userName) throws InterruptedException, IOException;
    void removeSolFile(String userName) throws InterruptedException, IOException;
    void complieProject(String userName) throws Exception;
    void compilePython(String userName) throws InterruptedException, IOException;
    String getCompileContent(String userName);
}
