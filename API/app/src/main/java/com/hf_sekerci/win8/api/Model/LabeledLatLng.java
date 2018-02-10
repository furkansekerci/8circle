
package com.hf_sekerci.win8.api.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LabeledLatLng {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("lng")
    @Expose
    private double lng;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public LabeledLatLng withLabel(String label) {
        this.label = label;
        return this;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public LabeledLatLng withLat(double lat) {
        this.lat = lat;
        return this;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public LabeledLatLng withLng(double lng) {
        this.lng = lng;
        return this;
    }

}
