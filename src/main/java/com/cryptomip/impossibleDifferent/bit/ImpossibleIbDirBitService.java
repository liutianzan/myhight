package com.cryptomip.impossibleDifferent.bit;

import java.io.IOException;
import java.util.List;

public interface ImpossibleIbDirBitService {
    String getDir(String projectName);
    List<String> getFileName(String path);
    List<String> getFileChoose(String projectName);
    String getContent(String fileName) throws Exception;
    void removeSolFile() throws InterruptedException, IOException;
}
