package com.main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CSVWriter {
    String CSV_FILE;

    CSVWriter (String CSV_FILE) {
        this.CSV_FILE = CSV_FILE;
    }

    public void writerCSV (List <Map.Entry<String, Integer>> valuesList) {
        try(FileWriter writer = new FileWriter(CSV_FILE, false)) {
            String title = "\"Word\",\"Frequency\",\"Frequency,%\""+"\n";        
            writer.write(title);
            for(int i=valuesList.size();i!=0;i--) {
                double frequency = valuesList.get(i-1).getValue()/(double)valuesList.size();
                String str = "\""+valuesList.get(i-1).getKey()+"\""+","+"\""+frequency+"\""+","+"\""+frequency*100+"\""+"\n";
                writer.write(str);

            }
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }    
}
 