package com.cryptomip.ZeroRelated.Trunk;

import java.io.IOException;
import java.util.List;

public interface ZcTrunkDirService {
    String getDir(String projectName);
    List<String> getFileName(String path);
    List<String> getFileChoose(String projectName);
    String getContent(String fileName) throws Exception;
    void removeSolFile() throws InterruptedException, IOException;
}
