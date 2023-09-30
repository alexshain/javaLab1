package com.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReadFile {
    String filename;

    ReadFile(String filename) {
        this.filename = filename;
    }

    public void readFile() {
        Reader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(filename));
            WordMaker readToString = new WordMaker(reader);
            CreateCSV writer = new CreateCSV();
            writer.writerCSV(readToString.readToArr());
        }
        catch (IOException e) {
            System.err.println("Error while reading file:" + e.getLocalizedMessage());
        }
        finally {
            if (null != reader) {
                try {
                    reader.close();
                }
                catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
}

