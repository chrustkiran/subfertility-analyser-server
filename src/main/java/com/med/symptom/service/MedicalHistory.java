package com.med.symptom.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface MedicalHistory {
    ArrayList<String> getAllMedicalHistories();
    ArrayList<String> getIndividualofMedHistory();
    HashMap<String, ArrayList<String>> getMedicalSubclasses();
}
