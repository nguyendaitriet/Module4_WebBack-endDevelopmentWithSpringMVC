package com.example.dictionary.service;

public class DictionaryServiceFactory {
    private static DictionaryService singleton;

    public static synchronized DictionaryService getInstance() {
        if (singleton == null) {
            singleton = new DictionaryService();
        }
        return singleton;
    }
}
