package com.med.symptom.service;

import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

@Service
public class OWLReaderImpl implements OWLReader {
    private OntModel parseOWL() {
        String fileName = "/home/chrustkiran/Thenuka/subfertility.owl";
        File owlFile = new File(fileName);
        OntModel model = null;
        try {
            FileReader fileReader = new FileReader(owlFile);
             model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(fileReader, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return model;
    }

    @Override
    public ArrayList<String> getClasses() {
        ArrayList<String> classList = new ArrayList();
        OntModel model = this.parseOWL();
         Iterator it = model.listClasses();
            while (it.hasNext()) {
                OntClass ontClass = (OntClass) it.next();
                try {
                    classList.add(ontClass.getURI().split("#")[1]);
                } catch (Exception e) {

                }
            }
            return classList;
    }

    @Override
    public ArrayList<String> getObjects() {
        ArrayList<String> objectList = new ArrayList<>();
        OntModel model = this.parseOWL();
        Iterator it = model.listObjectProperties();
        while (it.hasNext()) {
            ObjectProperty objectProperty = (ObjectProperty) it.next();
            try {
                objectList.add(objectProperty.getURI().split("#")[1]);
            } catch (Exception e) {

            }
        }
        return objectList;
    }
}
