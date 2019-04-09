package com.example.Differential.Bit;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface BitDifferentService {
    String saveText(String subText) throws Exception;
    String savePython() throws InterruptedException, IOException;
    void deletePython() throws InterruptedException, IOException;
    void removeSolFile() throws InterruptedException, IOException;
    void complieProject() throws Exception;
    void compilePython() throws InterruptedException, IOException;
    String getCompileContent();
}
