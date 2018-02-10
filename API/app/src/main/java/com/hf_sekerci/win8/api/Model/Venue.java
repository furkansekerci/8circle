
package com.hf_sekerci.win8.api.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Venue {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("contact")
    @Expose
    private Contact contact;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("verified")
    @Expose
    private boolean verified;
    @SerializedName("stats")
    @Expose
    private Stats stats;
    @SerializedName("venueRatingBlacklisted")
    @Expose
    private boolean venueRatingBlacklisted;
    @SerializedName("beenHere")
    @Expose
    private BeenHere beenHere;
    @SerializedName("specials")
    @Expose
    private Specials specials;
    @SerializedName("hereNow")
    @Expose
    private HereNow hereNow;
    @SerializedName("referralId")
    @Expose
    private String referralId;
    @SerializedName("venueChains")
    @Expose
    private List<Object> venueChains = null;
    @SerializedName("hasPerk")
    @Expose
    private boolean hasPerk;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("allowMenuUrlEdit")
    @Expose
    private boolean allowMenuUrlEdit;
    @SerializedName("venuePage")
    @Expose
    private VenuePage venuePage;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Venue withId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Venue withName(String name) {
        this.name = name;
        return this;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Venue withContact(Contact contact) {
        this.contact = contact;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Venue withLocation(Location location) {
        this.location = location;
        return this;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Venue withCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public Venue withVerified(boolean verified) {
        this.verified = verified;
        return this;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Venue withStats(Stats stats) {
        this.stats = stats;
        return this;
    }

    public boolean isVenueRatingBlacklisted() {
        return venueRatingBlacklisted;
    }

    public void setVenueRatingBlacklisted(boolean venueRatingBlacklisted) {
        this.venueRatingBlacklisted = venueRatingBlacklisted;
    }

    public Venue withVenueRatingBlacklisted(boolean venueRatingBlacklisted) {
        this.venueRatingBlacklisted = venueRatingBlacklisted;
        return this;
    }

    public BeenHere getBeenHere() {
        return beenHere;
    }

    public void setBeenHere(BeenHere beenHere) {
        this.beenHere = beenHere;
    }

    public Venue withBeenHere(BeenHere beenHere) {
        this.beenHere = beenHere;
        return this;
    }

    public Specials getSpecials() {
        return specials;
    }

    public void setSpecials(Specials specials) {
        this.specials = specials;
    }

    public Venue withSpecials(Specials specials) {
        this.specials = specials;
        return this;
    }

    public HereNow getHereNow() {
        return hereNow;
    }

    public void setHereNow(HereNow hereNow) {
        this.hereNow = hereNow;
    }

    public Venue withHereNow(HereNow hereNow) {
        this.hereNow = hereNow;
        return this;
    }

    public String getReferralId() {
        return referralId;
    }

    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }

    public Venue withReferralId(String referralId) {
        this.referralId = referralId;
        return this;
    }

    public List<Object> getVenueChains() {
        return venueChains;
    }

    public void setVenueChains(List<Object> venueChains) {
        this.venueChains = venueChains;
    }

    public Venue withVenueChains(List<Object> venueChains) {
        this.venueChains = venueChains;
        return this;
    }

    public boolean isHasPerk() {
        return hasPerk;
    }

    public void setHasPerk(boolean hasPerk) {
        this.hasPerk = hasPerk;
    }

    public Venue withHasPerk(boolean hasPerk) {
        this.hasPerk = hasPerk;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Venue withUrl(String url) {
        this.url = url;
        return this;
    }

    public boolean isAllowMenuUrlEdit() {
        return allowMenuUrlEdit;
    }

    public void setAllowMenuUrlEdit(boolean allowMenuUrlEdit) {
        this.allowMenuUrlEdit = allowMenuUrlEdit;
    }

    public Venue withAllowMenuUrlEdit(boolean allowMenuUrlEdit) {
        this.allowMenuUrlEdit = allowMenuUrlEdit;
        return this;
    }


    public VenuePage getVenuePage() {
        return venuePage;
    }

    public void setVenuePage(VenuePage venuePage) {
        this.venuePage = venuePage;
    }

    public Venue withVenuePage(VenuePage venuePage) {
        this.venuePage = venuePage;
        return this;
    }

}
