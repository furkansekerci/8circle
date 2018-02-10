
package com.hf_sekerci.win8.api.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HereNow {

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("groups")
    @Expose
    private List<Group> groups = null;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public HereNow withCount(int count) {
        this.count = count;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public HereNow withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public HereNow withGroups(List<Group> groups) {
        this.groups = groups;
        return this;
    }

}
