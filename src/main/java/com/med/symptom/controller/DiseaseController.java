package com.med.symptom.controller;

import com.med.symptom.model.DiseaseDTO;
import com.med.symptom.service.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@RestController
@CrossOrigin
public class DiseaseController {
    @Autowired
    Disease disease;

    @GetMapping("/get-ovul-dis")
    public ArrayList<String> getIntro() {
        return disease.getAllOvulatoryDisorder();
    }

    @PostMapping("/get-dis-test")
    public HashMap<String, HashSet<DiseaseDTO>> getDiseaseTest(
            @RequestBody HashMap<String, String> infoBody
    ) {
        return disease.getDiseaseTestMap(infoBody);
    }

}
