package com.med.symptom.service;

import com.med.symptom.model.DiseaseDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public interface Disease {
    String OVUL_DISORDER = "OvulatoryDisorder";
    String FINDS = "finds";
    String FIND_BY = "findby";
    ArrayList<String> getAllOvulatoryDisorder();
    HashMap<String, HashSet<DiseaseDTO>> getDiseaseTestMap();
}
