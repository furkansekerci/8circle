
package com.hf_sekerci.win8.api.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Likes {

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("groups")
    @Expose
    private List<Object> groups = null;
    @SerializedName("summary")
    @Expose
    private String summary;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Likes withCount(int count) {
        this.count = count;
        return this;
    }

    public List<Object> getGroups() {
        return groups;
    }

    public void setGroups(List<Object> groups) {
        this.groups = groups;
    }

    public Likes withGroups(List<Object> groups) {
        this.groups = groups;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Likes withSummary(String summary) {
        this.summary = summary;
        return this;
    }

}
