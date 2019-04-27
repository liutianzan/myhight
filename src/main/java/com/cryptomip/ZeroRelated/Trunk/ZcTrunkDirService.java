package com.cryptomip.ZeroRelated.Trunk;

import java.io.IOException;
import java.util.List;

public interface ZcTrunkDirService {
    String getDir(String projectName,String userName);
    List<String> getFileName(String path);
    List<String> getFileChoose(String projectName,String userName);
    String getContent(String fileName,String userName) throws Exception;
    void removeSolFile(String userName) throws InterruptedException, IOException;
}
