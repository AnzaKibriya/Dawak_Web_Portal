package model;

import com.google.gson.annotations.SerializedName;

public class PrescriptionHomeDelivery {

    @SerializedName("patient")
    private Patient patient;

    @SerializedName("OrderHomeDelivery")
    private OrderHomeDelivery OrderHomeDelivery;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public OrderHomeDelivery getOrderHomeDelivery() {
        return OrderHomeDelivery;
    }

    public void setOrderHomeDelivery(OrderHomeDelivery orderHomeDelivery) {
        this.OrderHomeDelivery = orderHomeDelivery;
    }

}
