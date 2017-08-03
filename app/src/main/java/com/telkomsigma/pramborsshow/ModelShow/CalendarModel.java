package com.telkomsigma.pramborsshow.ModelShow;

import com.telkomsigma.pramborsshow.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 20/07/2017.
 */

public class CalendarModel {

    private int image;
    private String hari;
    private String waktu;
    private String nama;
    private String ket;

    public CalendarModel() {
    }

    public CalendarModel(int image, String hari, String waktu, String nama, String ket) {
        this.image = image;
        this.hari = hari;
        this.waktu = waktu;
        this.nama = nama;
        this.ket = ket;
    }

    public static List<CalendarModel> getSelectChild1() {
        List<CalendarModel> listchild = new ArrayList<CalendarModel>();
        CalendarModel cmodel = new CalendarModel();
        cmodel.setImage(R.drawable.desta);
        cmodel.setWaktu("10:00 - 11:00");
        cmodel.setNama("Desta");
        cmodel.setKet("Penyiar paling keren banget");
        listchild.add(cmodel);
        return listchild;
    }

    public static List<CalendarModel> getSelectChild2() {
        List<CalendarModel> listchild = new ArrayList<CalendarModel>();
        CalendarModel cmodel = new CalendarModel();
        cmodel.setImage(R.drawable.christina);
        cmodel.setWaktu("10:00 - 11:00");
        cmodel.setNama("Christina");
        cmodel.setKet("Penyiar paling cantik banget");
        listchild.add(cmodel);
        return listchild;
    }

    public static List<CalendarModel> getSelectHeader() {
        List<CalendarModel> listdata = new ArrayList<CalendarModel>();
        CalendarModel cmodel = new CalendarModel();
        cmodel.setHari("Monday");
        listdata.add(cmodel);

        cmodel = new CalendarModel();
        cmodel.setHari("Tuesday");
        listdata.add(cmodel);

        cmodel = new CalendarModel();
        cmodel.setHari("Wednesday");
        listdata.add(cmodel);

        cmodel = new CalendarModel();
        cmodel.setHari("Thursday");
        listdata.add(cmodel);

        cmodel = new CalendarModel();
        cmodel.setHari("Friday");
        listdata.add(cmodel);

        cmodel = new CalendarModel();
        cmodel.setHari("Saturday");
        listdata.add(cmodel);

        cmodel = new CalendarModel();
        cmodel.setHari("Sunday");
        listdata.add(cmodel);

        return listdata;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }
}
