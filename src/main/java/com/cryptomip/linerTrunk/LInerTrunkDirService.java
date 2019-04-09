package com.cryptomip.linerTrunk;

import java.io.IOException;
import java.util.List;

public interface LInerTrunkDirService {
    String getDir(String projectName);
    List<String> getFileName(String path);
    String getContent(String fileName) throws Exception;
    void removeSolFile() throws InterruptedException, IOException;
}
