package com.cryptomip.linerTrunk;

import java.io.IOException;
import java.util.List;

public interface LInerTrunkDirService {
    String getDir(String projectName,String userName);
    List<String> getFileName(String path);
    String getContent(String fileName,String userName) throws Exception;
    void removeSolFile(String userName) throws InterruptedException, IOException;
}
