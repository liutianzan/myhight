package com.cryptomip.Differential.Bit;

import java.io.IOException;
import java.util.List;

public interface BitDirService {
    String getDir(String projectName);
    List<String> getFileName(String path);
    String getContent(String fileName) throws Exception;
    void removeSolFile() throws InterruptedException, IOException;
}
