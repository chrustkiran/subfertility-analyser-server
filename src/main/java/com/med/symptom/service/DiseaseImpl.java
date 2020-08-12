package com.med.symptom.service;

import com.med.symptom.model.DiseaseDTO;
import com.med.symptom.model.OWLObjectDTO;
import com.med.symptom.util.SetUtlil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@Service
public class DiseaseImpl extends SymptomService implements Disease {

    @Override
    public ArrayList<String> getAllOvulatoryDisorder() {
        return owlReader.getAllSubclasses(Disease.OVUL_DISORDER);
    }

    @Override
    public HashMap<String, HashSet<DiseaseDTO>> getDiseaseTestMap() {
        HashMap<String, HashSet<DiseaseDTO>> diseaseTestMap = new HashMap<>();
        if (!owlReader.getObjectProperties().isEmpty()) {
            for (OWLObjectDTO owlProp : owlReader.getObjectProperties()) {
                if (FINDS.equals(owlProp.getSuperObjectProperty())) {
                    DiseaseDTO diseaseDTO = new DiseaseDTO();
                    diseaseDTO.setDisease(owlProp.getRange());
                    diseaseDTO.setTest(owlProp.getDomain());
                    diseaseDTO.setPositiveResult(owlProp.getObjectProperty());

                    SetUtlil.putValueinHashMap(diseaseTestMap, diseaseDTO, diseaseDTO.getDisease());
                } else if (FIND_BY.equals(owlProp.getSuperObjectProperty())) {
                    DiseaseDTO diseaseDTO = new DiseaseDTO();
                    diseaseDTO.setDisease(owlProp.getDomain());
                    diseaseDTO.setTest(owlProp.getRange());
                    diseaseDTO.setPositiveResult(owlProp.getObjectProperty());

                    SetUtlil.putValueinHashMap(diseaseTestMap, diseaseDTO, diseaseDTO.getDisease());
                }
            }
        }

        return diseaseTestMap;
    }


}
