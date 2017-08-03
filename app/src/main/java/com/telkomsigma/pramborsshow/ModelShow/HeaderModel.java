package com.telkomsigma.pramborsshow.ModelShow;

import java.util.ArrayList;

/**
 * Created by user on 21/07/2017.
 */

public class HeaderModel {

    private String hari;
    private ArrayList<ChildModel> items;

    public HeaderModel() {
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public ArrayList<ChildModel> getItems() {
        return items;
    }

    public void setItems(ArrayList<ChildModel> items) {
        this.items = items;
    }
}
