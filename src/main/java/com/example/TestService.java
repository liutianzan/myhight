package com.example;

import java.io.IOException;

public interface TestService {
    public String saveText(String subText) throws Exception;
    public String buttonA(String sub) throws IOException, InterruptedException;
    public Object buttonB(String sub) throws IOException, InterruptedException;
    public String savePython() throws InterruptedException, IOException;
    public void deletePython() throws InterruptedException, IOException;
    public String complieProject() throws Exception;
    public String compilePython() throws InterruptedException, IOException;
    public String getCompileContent();
}
