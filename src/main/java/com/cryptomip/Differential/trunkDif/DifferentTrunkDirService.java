package com.cryptomip.Differential.trunkDif;


import java.io.IOException;
import java.util.List;

public interface DifferentTrunkDirService {
    public String getDir(String projectName);
    List<String> getFileChoose(String projectName);
    public String getContent(String fileName) throws Exception;

    List<String> getFileName(String path);

    public void removeSolFile() throws InterruptedException, IOException;
}