package com.med.symptom.service;

import com.med.symptom.model.DiseaseDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public interface Disease {
    String OVUL_DISORDER = "OvulatoryDisorder";
    String ENDOMETRIOSIS = "Endometriosis";
    String HYPOTHALAMO_FAILURE = "HypothalamoPituitaryFailure";
    String POLY_CYSTIC_SYNDROME = "PolycysticOverianSyndrome";
    String TUBAL_DISORDER = "TubalDisorder";
    String PREMATURE_FAILURE = "PrematureOverianFailure";

    String FAMILY_HISTORY = "Family_History";
    String MENSURAL_HISTORY_PAIN = "Mensural_History_Pain";
    String PRE_HIST_PELVIC = "Previous_Historyof_Pelvic_Inflammatory_Disease";


    String FINDS = "finds";
    String FIND_BY = "findby";
    HashMap<String, String> diseaseMedHistMap = new HashMap<String, String>(){{
        put(FAMILY_HISTORY, HYPOTHALAMO_FAILURE + ',' + POLY_CYSTIC_SYNDROME + ',' + PREMATURE_FAILURE);
        put(MENSURAL_HISTORY_PAIN, ENDOMETRIOSIS);
        put(PRE_HIST_PELVIC, TUBAL_DISORDER);
    }};
    ArrayList<String> getAllOvulatoryDisorder();
    HashMap<String, HashSet<DiseaseDTO>> getDiseaseTestMap(HashMap<String, String> infoBody);
}
