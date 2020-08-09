package com.med.symptom.controller;

import com.med.symptom.service.OWLReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class SymptomController {

    @Autowired
    OWLReader owlReader;

    @GetMapping("/getclass")
    public List<String> getDisease() {
        return owlReader.getClasses();
    }

    @GetMapping("/getobject")
    public ArrayList<String> getObject() {
        return owlReader.getObjects();
    }
}
