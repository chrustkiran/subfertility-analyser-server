package com.med.symptom.service;

import com.med.symptom.model.OWLObjectDTO;
import com.med.symptom.util.SetUtlil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@Service
public class TreatmentImpl extends SymptomService implements Treatment {

    @Override
    public HashMap<String, HashSet<String>> getTreatmentFor(String disease) {
        HashMap<String, HashSet<String>> treatmentsMap = new HashMap<>();
        ArrayList<OWLObjectDTO> owlObjects = owlReader.getObjectProperties();
        if (!owlObjects.isEmpty()) {
            for (OWLObjectDTO owlProp : owlObjects) {
                if (IS_TREAT_FOR.equals(owlProp.getSuperObjectProperty())
                        && disease.equals(owlProp.getRange())) {
                    SetUtlil.putValueinHashMap(treatmentsMap, owlProp.getDomain(), owlProp.getObjectProperty());
                }
            }
        }
        return treatmentsMap;
    }
}
