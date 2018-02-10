
package com.hf_sekerci.win8.api.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats {

    @SerializedName("checkinsCount")
    @Expose
    private int checkinsCount;
    @SerializedName("usersCount")
    @Expose
    private int usersCount;
    @SerializedName("tipCount")
    @Expose
    private int tipCount;

    public int getCheckinsCount() {
        return checkinsCount;
    }

    public void setCheckinsCount(int checkinsCount) {
        this.checkinsCount = checkinsCount;
    }

    public Stats withCheckinsCount(int checkinsCount) {
        this.checkinsCount = checkinsCount;
        return this;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public Stats withUsersCount(int usersCount) {
        this.usersCount = usersCount;
        return this;
    }

    public int getTipCount() {
        return tipCount;
    }

    public void setTipCount(int tipCount) {
        this.tipCount = tipCount;
    }

    public Stats withTipCount(int tipCount) {
        this.tipCount = tipCount;
        return this;
    }

}
