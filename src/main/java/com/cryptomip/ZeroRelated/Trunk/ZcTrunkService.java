package com.cryptomip.ZeroRelated.Trunk;

import java.io.IOException;

public interface ZcTrunkService {
    String saveText(String subText,String userName) throws Exception;
    String savePython(String userName) throws InterruptedException, IOException;
    void deletePython(String userName) throws InterruptedException, IOException;
    void removeSolFile(String userName) throws InterruptedException, IOException;
    String complieProject(String userName) throws Exception;
    String compilePython(String userName) throws InterruptedException, IOException;
    String getCompileContent(String userName);
}
