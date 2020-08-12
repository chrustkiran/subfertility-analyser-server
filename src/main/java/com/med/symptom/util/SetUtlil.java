package com.med.symptom.util;

import java.util.HashMap;
import java.util.HashSet;

public class SetUtlil {
    public static <Key, ValSet> void putValueinHashMap(HashMap<Key, HashSet<ValSet>> hashMap, ValSet valObj, Key key) {
        if(hashMap.containsKey(key)) {
            hashMap.get(key).add(valObj);
        } else {
            HashSet<ValSet> valSets = new HashSet<>();
            valSets.add(valObj);
            hashMap.put(key, valSets);
        }
    }
}
