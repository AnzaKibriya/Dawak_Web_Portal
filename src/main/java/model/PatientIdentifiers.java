package model;

import com.google.gson.annotations.SerializedName;

public class PatientIdentifiers {

    public boolean isProject() {
        return Project;
    }

    public void setProject(boolean project) {
        Project = project;
    }

    public boolean isExternalEPI() {
        return ExternalEPI;
    }

    public void setExternalEPI(boolean externalEPI) {
        ExternalEPI = externalEPI;
    }

    public boolean isExternalPatientId() {
        return ExternalPatientId;
    }

    public void setExternalPatientId(boolean externalPatientId) {
        ExternalPatientId = externalPatientId;
    }

    public boolean isMRNDomain() {
        return MRNDomain;
    }

    public void setMRNDomain(boolean MRNDomain) {
        this.MRNDomain = MRNDomain;
    }

    public String getMRN() {
        return MRN;
    }

    public void setMRN(String MRN) {
        this.MRN = MRN;
    }

    @SerializedName("MRN")
    private String MRN;
    @SerializedName("MRNDomain")
    private boolean MRNDomain;
    @SerializedName("ExternalPatientId")
    private boolean ExternalPatientId;
    @SerializedName("ExternalEPI")
    private boolean ExternalEPI;
    @SerializedName("Project")
    private boolean Project;

}
