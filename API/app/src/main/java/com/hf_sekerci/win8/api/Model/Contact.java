
package com.hf_sekerci.win8.api.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contact {

    @SerializedName("twitter")
    @Expose
    private String twitter;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("formattedPhone")
    @Expose
    private String formattedPhone;
    @SerializedName("facebook")
    @Expose
    private String facebook;
    @SerializedName("facebookUsername")
    @Expose
    private String facebookUsername;
    @SerializedName("facebookName")
    @Expose
    private String facebookName;

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public Contact withTwitter(String twitter) {
        this.twitter = twitter;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Contact withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getFormattedPhone() {
        return formattedPhone;
    }

    public void setFormattedPhone(String formattedPhone) {
        this.formattedPhone = formattedPhone;
    }

    public Contact withFormattedPhone(String formattedPhone) {
        this.formattedPhone = formattedPhone;
        return this;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public Contact withFacebook(String facebook) {
        this.facebook = facebook;
        return this;
    }

    public String getFacebookUsername() {
        return facebookUsername;
    }

    public void setFacebookUsername(String facebookUsername) {
        this.facebookUsername = facebookUsername;
    }

    public Contact withFacebookUsername(String facebookUsername) {
        this.facebookUsername = facebookUsername;
        return this;
    }

    public String getFacebookName() {
        return facebookName;
    }

    public void setFacebookName(String facebookName) {
        this.facebookName = facebookName;
    }

    public Contact withFacebookName(String facebookName) {
        this.facebookName = facebookName;
        return this;
    }

}
