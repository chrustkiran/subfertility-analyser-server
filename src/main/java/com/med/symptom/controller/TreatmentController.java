package com.med.symptom.controller;

import com.med.symptom.service.Treatment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;

@RestController
public class TreatmentController {
    @Autowired
    Treatment treatment;

    @GetMapping("/get-treatment")
    public HashMap<String, HashSet<String>> getTreatmentFor(@RequestParam String disease) {
        return treatment.getTreatmentFor(disease);
    }
}
