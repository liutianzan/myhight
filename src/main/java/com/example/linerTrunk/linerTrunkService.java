package com.example.linerTrunk;

import java.io.IOException;

public interface linerTrunkService {
    String saveText(String subText) throws Exception;
    String savePython() throws InterruptedException, IOException;
    void deletePython() throws InterruptedException, IOException;
    void removeSolFile() throws InterruptedException, IOException;
    String complieProject() throws Exception;
    String compilePython() throws InterruptedException, IOException;
}
