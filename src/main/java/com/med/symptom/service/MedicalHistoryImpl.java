package com.med.symptom.service;

import com.med.symptom.common.Constants;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.rdf.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@Service
public class MedicalHistoryImpl extends SymptomService implements MedicalHistory {
    private final String MEDICAL_HISTORY = "MedicalHistory";
    private final String INDIVIDUAL_ASSESSMENT = "IntroductionAssessment";

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
        for (String res: this.getAllMedicalHistories()) {

        }
        return medIndividuals;
    }

    @Override
    public HashMap<String, ArrayList<String>> getMedicalSubclasses() {
        HashMap<String, ArrayList<String>> medHistoryFieldMap = new HashMap<>();
        for (String res: this.getAllMedicalHistories()) {
            if (!res.equals(INDIVIDUAL_ASSESSMENT)) {
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
}
