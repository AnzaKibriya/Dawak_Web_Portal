package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Order {
    @SerializedName("parentFin")
    private String parentFin;

    @SerializedName("physicianEncounterId")
    private String physicianEncounterId;

    @SerializedName("physicianOrderDate")
    private String physicianOrderDate;

    @SerializedName("orderVisitDate")
    private String orderVisitDate;

    @SerializedName("orderLocation")
    private OrderLocation orderLocation;

    @SerializedName("physician")
    private Physician physician;

    @SerializedName("medications")
    private List<Medication> medications;
    public String getParentFin() {
        return parentFin;
    }

    public void setParentFin(String parentFin) {
        this.parentFin = parentFin;
    }

    public String getPhysicianEncounterId() {
        return physicianEncounterId;
    }

    public void setPhysicianEncounterId(String physicianEncounterId) {
        this.physicianEncounterId = physicianEncounterId;
    }

    public String getPhysicianOrderDate() {
        return physicianOrderDate;
    }

    public void setPhysicianOrderDate(String physicianOrderDate) {
        this.physicianOrderDate = physicianOrderDate;
    }

    public String getOrderVisitDate() {
        return orderVisitDate;
    }

    public void setOrderVisitDate(String orderVisitDate) {
        this.orderVisitDate = orderVisitDate;
    }

    public OrderLocation getOrderLocation() {
        return orderLocation;
    }

    public void setOrderLocation(OrderLocation orderLocation) {
        this.orderLocation = orderLocation;
    }

    public Physician getPhysician() {
        return physician;
    }

    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }
}




