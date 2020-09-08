package com.med.symptom.service;

import com.med.symptom.common.Constants;
import org.apache.jena.ontology.OntClass;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class MedicalHistoryImpl extends SymptomService implements MedicalHistory {
    private final String MEDICAL_HISTORY = "MedicalHistory";
    private final String INTRODUCTION_ASSESSMENT = "IntroductionAssessment";
    private final String SYMPTOM_ANALYSIS = "SymptomAnalysis";
    private final String HISTORY_OF_PRESENT = "HistoryOfPresentComplaint";
    private final String RISK_BEHAVIOURS = "RiskBehaviors";

    @Override
    public ArrayList<String> getAllMedicalHistories() {
        ArrayList<String> medicalHistories = new ArrayList<>();
        String URI = Constants.URI;
        OntClass ontClass = owlReader.parseOWL().createClass(URI + MEDICAL_HISTORY);
        Iterator it = ontClass.listSubClasses();
        while (it.hasNext()) {
            medicalHistories.add(((OntClass) it.next()).getURI().split(Constants.OWL_RES_DIVIDER)[1]);
        }
        return medicalHistories;
    }

    @Override
    public ArrayList<String> getIndividualofMedHistory() {
        ArrayList<String> medIndividuals = new ArrayList<>();
        for (String res : this.getAllMedicalHistories()) {

        }
        return medIndividuals;
    }

    @Override
    public HashMap<String, ArrayList<String>> getMedicalSubclasses() {
        HashMap<String, ArrayList<String>> medHistoryFieldMap = new HashMap<>();
        for (String res : this.getAllMedicalHistories()) {
            if (!res.equals(INTRODUCTION_ASSESSMENT)) {
                owlReader.getAllSubclasses(res).forEach(s -> {
                    ArrayList list = owlReader.getAllSubclasses(s);
                    if (!list.isEmpty()) {
                        medHistoryFieldMap.put(s, list);
                    } else {
                        medHistoryFieldMap.put(s, owlReader.getAllIndividualByType(s));
                    }

                });
            }
        }
        return medHistoryFieldMap;
    }

    @Override
    public ArrayList<String> getAllMedHistories() {
        ArrayList<String> allMedHistories = new ArrayList<>();
        for (String res : this.getAllMedicalHistories()) {
            if (!res.equals(INTRODUCTION_ASSESSMENT)) {
                owlReader.getAllSubclasses(res).forEach(s -> {
                    ArrayList list = owlReader.getAllSubclasses(s);
                    if (!list.isEmpty()) {
                        allMedHistories.addAll(list);
                    } else {
                        allMedHistories.addAll(owlReader.getAllIndividualByType(s));
                    }

                });
            }
        }
        return allMedHistories;
    }

    @Override
    public ArrayList<String> getAllIntroductionAssessment() {
        ArrayList<String> allIntroducationAssessments = new ArrayList<>();
        for (String res : this.getAllMedicalHistories()) {
            if (res.equals(INTRODUCTION_ASSESSMENT)) {
                owlReader.getAllIndividualByType(res).forEach(s -> {
                    allIntroducationAssessments.add(s);
                });
            }
        }
        return allIntroducationAssessments;
    }

    @Override
    public HashMap<String, Object> getSymptomAnalysis() {
        HashMap<String, Object> allSymptoms = new HashMap<>();
        for (String res : this.getAllMedicalHistories()) {
            if (res.equals(HISTORY_OF_PRESENT)) {
                owlReader.getAllSubclasses(res).forEach(history -> {
                            if (SYMPTOM_ANALYSIS.equals(history)) {
                                owlReader.getAllSubclasses(history).forEach(s -> {
                                    ArrayList<String> subclasses = owlReader.getAllSubclasses(s);
                                    HashMap<String, List<String>> symptomsWithSubclasses = new HashMap<>();
                                    if (!subclasses.isEmpty()) {
                                        subclasses.forEach(subclass1 -> {
                                            ArrayList<String> instances = owlReader.getAllIndividualByType(subclass1);
                                            symptomsWithSubclasses.put(subclass1, instances);
                                        });
                                        allSymptoms.put(s, symptomsWithSubclasses);
                                    } else {
                                        allSymptoms.put(s, owlReader.getAllIndividualByType(s));
                                    }
                                });
                            }
                        }
                );
            }
        }
        return allSymptoms;
    }

    @Override
    public ArrayList<String> getRiskBehaviour() {
        ArrayList<String> riskBehaviours = new ArrayList<>();
        for (String res : this.getAllMedicalHistories()) {
            if (res.equals(HISTORY_OF_PRESENT)) {
                owlReader.getAllSubclasses(res).forEach(history -> {
                    if (RISK_BEHAVIOURS.equals(history)) {
                        riskBehaviours.addAll(owlReader.getAllIndividualByType(history));
                    }
                });
            }
        }
        return riskBehaviours;
    }


}
