
package com.layercontent.spoonacularcallculatortwo.search.Tarifbilgi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class WinePairing {

    @SerializedName("pairedWines")
    @Expose
    private List<Object> pairedWines = null;
    @SerializedName("pairingText")
    @Expose
    private String pairingText;
    @SerializedName("productMatches")
    @Expose
    private List<Object> productMatches = null;

    public List<Object> getPairedWines() {
        return pairedWines;
    }

    public void setPairedWines(List<Object> pairedWines) {
        this.pairedWines = pairedWines;
    }

    public String getPairingText() {
        return pairingText;
    }

    public void setPairingText(String pairingText) {
        this.pairingText = pairingText;
    }

    public List<Object> getProductMatches() {
        return productMatches;
    }

    public void setProductMatches(List<Object> productMatches) {
        this.productMatches = productMatches;
    }

}
