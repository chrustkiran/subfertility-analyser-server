package com.med.symptom.service;

import java.util.HashMap;
import java.util.HashSet;

public interface Treatment {
    String IS_TREAT_FOR = "isTreatFor";

    HashMap<String, HashSet<String>> getTreatmentFor(String disease);
}
