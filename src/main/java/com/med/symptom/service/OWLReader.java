package com.med.symptom.service;

import org.apache.jena.ontology.OntModel;

import java.util.ArrayList;


public interface OWLReader {
     ArrayList<String> getClasses();
     ArrayList<String> getObjects();

}
