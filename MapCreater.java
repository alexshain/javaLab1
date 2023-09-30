package com.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapCreater {
    ArrayList<String> arrayList;

    MapCreater (ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    public List <Map.Entry<String, Integer>> mapGetter() {
        Map<String, Integer> words = new HashMap<String, Integer>();
        for(String item: arrayList) {
            if(!words.containsKey(item)) {
                words.put(item, 1);
            } else {
                int newValue = words.get(item) + 1;
                words.put(item, newValue);
            }
        } 
        List <Map.Entry<String, Integer>> valuesList = new ArrayList<>(words.entrySet());
        Collections.sort(valuesList, Comparator.comparing(Map.Entry::getValue));
        return valuesList;
    }
}
