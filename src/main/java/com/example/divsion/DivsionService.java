package com.example.divsion;

import org.python.antlr.ast.Str;

import javax.sql.rowset.spi.SyncResolver;
import java.io.IOException;

public interface DivsionService {
    String saveText(String subText) throws Exception;
    String savePython() throws InterruptedException, IOException;
    void deletePython() throws InterruptedException, IOException;
    void removeSolFile() throws InterruptedException, IOException;
    String complieProject() throws Exception;
    String compilePython() throws InterruptedException, IOException;
    String getCompileContent();
}
