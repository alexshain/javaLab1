package com.main;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WordCounter {
    Reader reader;

    WordCounter(Reader reader) {
        this.reader = reader;
    }

    public List <Map.Entry<String, Integer>> readToArr() {
        StringBuilder fullString = new StringBuilder();
        List<String> arrayList = new ArrayList<>();
        List<String> arrayListFinal = new ArrayList<>();
        try {
            int line = reader.read();
            while (line != -1) {
                if(Character.isLetterOrDigit(line)) {
                    fullString.append((char)line);
                } else {
                    arrayList.add(fullString.toString());
                    fullString.setLength(0);;
                }
                line = reader.read();
            }
            for(String item: arrayList) {
                if(item != ""){
                    arrayListFinal.add(item);
                }
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        MapCreator words = new MapCreator(arrayListFinal);
        return words.mapGetter();
    }
}
