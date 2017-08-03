package com.telkomsigma.pramborsshow.ModelShow;

public class ListModel {

    private int id;
    private String title;
    private String info;
    private String image;
    private String detail;

    public ListModel() {
    }

    public ListModel(int id, String title, String info, String image, String detail) {
        this.id = id;
        this.title = title;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
