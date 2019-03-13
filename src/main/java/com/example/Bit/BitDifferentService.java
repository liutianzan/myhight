package com.example.Bit;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface BitDifferentService {
    String saveText(String subText) throws Exception;
    String savePython() throws InterruptedException, IOException;
    void deletePython() throws InterruptedException, IOException;
    void removeSolFile() throws InterruptedException, IOException;
    String complieProject() throws Exception;
    String compilePython() throws InterruptedException, IOException;
}
