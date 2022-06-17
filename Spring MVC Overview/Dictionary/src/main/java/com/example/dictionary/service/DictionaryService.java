package com.example.dictionary.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DictionaryService {

    private static final Map<String, String> data = new HashMap<>();

    static {
        data.put("tree","cay coi");
        data.put("sky","bau troi");
        data.put("location","vi tri");
        data.put("network","mang luoi");
        data.put("information", "thong tin");
    }

    public String lookUp(String input) {
        Set<String> keySet = data.keySet();
        for (String key: keySet) {
            if (input.equals(key)) {
                return data.get(key);
            }
        }
        return null;
    }
}
