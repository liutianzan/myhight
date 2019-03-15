package com.example.impossibleDifferent;

import java.io.IOException;
import java.util.List;

public interface ImpossibleIbDirService {
    String getDir(String projectName);
    List<String> getFileName(String path);
    String getContent(String fileName) throws Exception;
    void removeSolFile() throws InterruptedException, IOException;
}
