package com.telkomsigma.pramborsshow.HelperShow;

/**
 * Created by user on 21/07/2017.
 */

public class Server {

    public static final String URL = "http://180.250.19.86/prambors/";

    public static final String url_getshow = URL + "api_get_show.php";
    public static final String url_getcalendar = URL + "api_get_calendar.php";
    public static final String url_getday = URL + "api_get_day.php";

    // field get show in listview
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String INFO = "info";
    public static final String IMAGE = "image";
    public static final String DETAIL = "detail";

    // field get calendar in calendarview
    public static final String ID_CAL = "id";
    public static final String DAY_CAL = "day";
    public static final String TIME_CAL = "time";
    public static final String SHOWS_CAL = "shows";
    public static final String INFO_CAL = "info";
    public static final String IMAGE_CAL = "image";
    public static final String DETAIL_CAL = "detail";

    public static final String tag_json_obj = "json_obj_req";

}
