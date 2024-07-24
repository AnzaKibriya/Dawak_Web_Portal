package model;

import com.google.gson.annotations.SerializedName;

public class RxMedication {

    @SerializedName("isOTCProduct")
    private boolean isOTCProduct;
    @SerializedName("isRemoved")
    private boolean isRemoved;
    @SerializedName("id")
    private int id;
    @SerializedName("newQuantity")
    private int newQuantity;
    @SerializedName("previousQuantity")
    private int previousQuantity;

    // Getters and Setters
    public boolean isOTCProduct() {
        return isOTCProduct;
    }

    public void setOTCProduct(boolean isOTCProduct) {
        this.isOTCProduct = isOTCProduct;
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setRemoved(boolean isRemoved) {
        this.isRemoved = isRemoved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNewQuantity() {
        return newQuantity;
    }

    public void setNewQuantity(int newQuantity) {
        this.newQuantity = newQuantity;
    }

    public int getPreviousQuantity() {
        return previousQuantity;
    }

    public void setPreviousQuantity(int previousQuantity) {
        this.previousQuantity = previousQuantity;
    }



}
