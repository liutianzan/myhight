package com.cryptomip.Differential.Bit;

import org.springframework.stereotype.Service;

import java.io.IOException;


public interface BitDifferentService {
    String saveText(String subText,String userName) throws Exception;
    String savePython(String userName) throws InterruptedException, IOException;
    void deletePython(String userName) throws InterruptedException, IOException;
    void removeSolFile(String userName) throws InterruptedException, IOException;
    void complieProject(String userName) throws Exception;
    void compilePython(String userName) throws InterruptedException, IOException;
    String getCompileContent();
}
