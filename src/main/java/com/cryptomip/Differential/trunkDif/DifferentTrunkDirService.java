package com.cryptomip.Differential.trunkDif;


import java.io.IOException;
import java.util.List;

public interface DifferentTrunkDirService {
    public String getDir(String projectName,String userName);
    List<String> getFileChoose(String projectName,String userName);
    public String getContent(String fileName,String userName) throws Exception;

    List<String> getFileName(String path);

    public void removeSolFile(String userName) throws InterruptedException, IOException;
}