
package com.hf_sekerci.win8.api.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("pluralName")
    @Expose
    private String pluralName;
    @SerializedName("shortName")
    @Expose
    private String shortName;
    @SerializedName("icon")
    @Expose
    private Icon icon;
    @SerializedName("primary")
    @Expose
    private boolean primary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Category withId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category withName(String name) {
        this.name = name;
        return this;
    }

    public String getPluralName() {
        return pluralName;
    }

    public void setPluralName(String pluralName) {
        this.pluralName = pluralName;
    }

    public Category withPluralName(String pluralName) {
        this.pluralName = pluralName;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Category withShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public Category withIcon(Icon icon) {
        this.icon = icon;
        return this;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public Category withPrimary(boolean primary) {
        this.primary = primary;
        return this;
    }

}
