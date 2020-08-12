package com.med.symptom.model;

public class OWLObjectDTO {
    private String objectProperty;
    private String superObjectProperty;
    private String domain;
    private String range;

    @Override
    public String toString() {
        return "OWLObjectDTO{" +
                "objectProperty='" + objectProperty + '\'' +
                ", superObjectProperty='" + superObjectProperty + '\'' +
                ", domain='" + domain + '\'' +
                ", range='" + range + '\'' +
                '}';
    }

    public String getObjectProperty() {
        return objectProperty;
    }

    public void setObjectProperty(String objectProperty) {
        this.objectProperty = objectProperty;
    }

    public String getSuperObjectProperty() {
        return superObjectProperty;
    }

    public void setSuperObjectProperty(String superObjectProperty) {
        this.superObjectProperty = superObjectProperty;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }
}
