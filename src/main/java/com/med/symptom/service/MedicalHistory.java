package com.med.symptom.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface MedicalHistory {
    ArrayList<String> getAllMedicalHistories();
    ArrayList<String> getIndividualofMedHistory();
    HashMap<String, ArrayList<String>> getMedicalSubclasses();
    ArrayList<String> getAllMedHistories();
    ArrayList<String> getAllIntroductionAssessment();
    HashMap<String, Object> getSymptomAnalysis();
    ArrayList<String> getRiskBehaviour();
}
