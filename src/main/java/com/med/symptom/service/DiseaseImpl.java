package com.med.symptom.service;

import com.med.symptom.model.DiseaseDTO;
import com.med.symptom.model.OWLObjectDTO;
import com.med.symptom.util.SetUtlil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

@Service
public class DiseaseImpl extends SymptomService implements Disease {
    private final static String YES = "Yes";
    private final static String NO = "No";
    private final static String ALCOHOL = "Alcohol";
    private final static String SMOKING = "Smoking";

    @Override
    public ArrayList<String> getAllOvulatoryDisorder() {
        return owlReader.getAllSubclasses(Disease.OVUL_DISORDER);
    }

    @Override
    public HashMap<String, HashSet<DiseaseDTO>> getDiseaseTestMap(HashMap<String, String> infoBody) {
        HashMap<String, HashSet<DiseaseDTO>> diseaseTestMap = new HashMap<>();
        if (!owlReader.getObjectProperties().isEmpty()) {
                for (OWLObjectDTO owlProp : owlReader.getObjectProperties()) {
                   if (FIND_BY.equals(owlProp.getSuperObjectProperty())) {
                       for (String key: Disease.diseaseMedHistMap.keySet()) {
                           if (YES.equalsIgnoreCase(infoBody.get(key))
                                   && Arrays.asList(Disease.diseaseMedHistMap.get(key)
                                   .split(",")).contains(owlProp.getDomain())) {
                               DiseaseDTO diseaseDTO = new DiseaseDTO();
                               diseaseDTO.setDisease(owlProp.getDomain());
                               diseaseDTO.setTest(owlProp.getRange());
                               diseaseDTO.setPositiveResult(owlProp.getObjectProperty());

                               SetUtlil.putValueinHashMap(diseaseTestMap, diseaseDTO, diseaseDTO.getDisease());
                           }
                       }
                    }
                }

        }

        return diseaseTestMap;
    }


}
