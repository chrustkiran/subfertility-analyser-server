package com.med.symptom.service;

import com.med.symptom.common.Constants;
import com.med.symptom.model.OWLObjectDTO;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

@Service
public class OWLReaderImpl implements OWLReader {

    @Value("${file.location}")
    String OWL_FILE;

    private ArrayList<OWLObjectDTO> owlObjs = new ArrayList<>();

    @Override
    public OntModel parseOWL() {
        String fileName = this.OWL_FILE;
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
    public ArrayList<String> getAllSubclasses(String className) {
        ArrayList<String> subClasses = new ArrayList<>();
        OntClass ontClass = parseOWL().createClass(Constants.URI + className);
        Iterator itr = ontClass.listSubClasses();
        while (itr.hasNext()) {
            String subClass = ((OntClass) itr.next()).getURI().split(Constants.OWL_RES_DIVIDER)[1];
            subClasses.add(subClass);
        }
        return subClasses;
    }

    @Override
    public ArrayList<String> getAllIndividualByType(String type) {
        ArrayList<String> individuals = new ArrayList<>();
        Resource rdfType = parseOWL().createOntResource(Constants.URI + type);
        Iterator it = parseOWL().listIndividuals(rdfType);
        while (it.hasNext()) {
            individuals.add(((Resource) it.next()).getURI().split(Constants.OWL_RES_DIVIDER)[1]);
        }
        return individuals;
    }

    @Override
    public ArrayList<OWLObjectDTO> getObjectProperties() {
        if (owlObjs.isEmpty()) {
            Iterator itr = parseOWL().listObjectProperties();
            while (itr.hasNext()) {
                ObjectProperty property = (ObjectProperty) itr.next();
                OWLObjectDTO owlObject = new OWLObjectDTO();

                owlObject.setObjectProperty(getNameOfURI(property.getURI()));
                owlObject.setSuperObjectProperty(property.getSuperProperty() != null ? getNameOfURI(property.getSuperProperty().getURI()): "");
                owlObject.setDomain(getNameOfURI(property.getDomain().getURI()));
                owlObject.setRange(getNameOfURI(property.getRange().getURI()));
                owlObjs.add(owlObject);
            }
        }
        return owlObjs;
    }

    private String getNameOfURI(String name) {
        if (name != null && !name.isEmpty()) {
            return name.split(Constants.OWL_RES_DIVIDER)[1];
        }
        return "";
    }







  /*  @Override
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


    @Override
    public ArrayList<String> getIntroductionAssessment() {

        ArrayList<String> medicalHistories = new ArrayList<>();
        String URI = "http://www.subfertility.com/ontologies/2020/4/subfertility.owl#";
        Resource rdfType = this.parseOWL().createOntResource(URI + "IntroductionAssessment");
        Iterator it = this.parseOWL().listIndividuals(rdfType);
        while (it.hasNext()) {
            medicalHistories.add(((Resource) it.next()).getURI().split("#")[1]);
        }
        return medicalHistories;

    }*/
}
