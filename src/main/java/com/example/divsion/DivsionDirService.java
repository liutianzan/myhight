package com.example.divsion;

import java.io.IOException;
import java.util.List;

public interface DivsionDirService {
    String getDir(String projectName);
    List<String> getFileName(String path);
    List<String> getFileChoose(String projectName);
    String getContent(String fileName) throws Exception;
    void removeSolFile() throws InterruptedException, IOException;
}
