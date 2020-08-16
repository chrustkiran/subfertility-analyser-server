package com.med.symptom.controller;

import com.med.symptom.service.MedicalHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class SymptomController {

    @Autowired
    MedicalHistory medicalHistory;

    @GetMapping("/get-med-history-individuals")
    public ArrayList<String> getIntro() {
        return medicalHistory.getIndividualofMedHistory();
    }


    @GetMapping("/get-med-history")
    public ArrayList<String> getMedHistory() {
        return medicalHistory.getAllMedicalHistories();
    }

    @GetMapping("/get-med-subclass")
    public HashMap<String, ArrayList<String>> getMedSubClass() {
        return medicalHistory.getMedicalSubclasses();
    }

    @GetMapping("/get-all-med-history")
    public ArrayList<String> getMedAllMedHistories() {
        return medicalHistory.getAllMedHistories();
    }
}
