package com.med.symptom.model;

public class DiseaseDTO {
    private String disease;
    private String test;
    private String positiveResult;

    @Override
    public String toString() {
        return "DiseaseDTO{" +
                "disease='" + disease + '\'' +
                ", test='" + test + '\'' +
                ", positiveResult='" + positiveResult + '\'' +
                '}';
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getPositiveResult() {
        return positiveResult;
    }

    public void setPositiveResult(String positiveResult) {
        this.positiveResult = positiveResult;
    }
}
