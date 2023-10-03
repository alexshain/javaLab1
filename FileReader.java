package com.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Map; 

public class FileReader {
    String filename;

    FileReader(String filename) {
        this.filename = filename;
    }

    public List <Map.Entry<String, Integer>> readFile() {
        Reader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(filename));
            return (new WordCounter(reader)).readToArr();
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
        return (new WordCounter(reader)).readToArr();
    }
}

