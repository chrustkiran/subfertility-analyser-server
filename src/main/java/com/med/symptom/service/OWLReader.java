package com.med.symptom.service;

import com.med.symptom.model.OWLObjectDTO;
import org.apache.jena.ontology.OntModel;

import java.util.ArrayList;


public interface OWLReader {
    /* HashMap<String, Set<String>> diseaseTest = new HashMap<>();
     HashMap<String, String> testDisease = new HashMap<>();*/


     OntModel parseOWL();
     ArrayList<String> getAllSubclasses(String className);
     ArrayList<String> getAllIndividualByType(String type);
     ArrayList<OWLObjectDTO> getObjectProperties();
    /* ArrayList<String> getClasses();
     ArrayList<String> getObjects();
     ArrayList<String> getIntroductionAssessment();*/

}
