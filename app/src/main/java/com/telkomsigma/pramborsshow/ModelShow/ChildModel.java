package com.telkomsigma.pramborsshow.ModelShow;

/**
 * Created by user on 20/07/2017.
 */

public class ChildModel {

    private int id;
    private String day;
    private String time;
    private String shows;
    private String info;
    private String image;
    private String detail;

    public ChildModel() {
    }

    public ChildModel(int id, String day, String time, String shows, String info, String image, String detail) {
        this.id = id;
        this.day = day;
        this.time = time;
        this.shows = shows;
        this.info = info;
        this.image = image;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getShows() {
        return shows;
    }

    public void setShows(String shows) {
        this.shows = shows;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
