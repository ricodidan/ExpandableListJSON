package com.telkomsigma.pramborsshow.ControllerShow;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.telkomsigma.pramborsshow.AdapterShow.ExpandListAdapter;
import com.telkomsigma.pramborsshow.HelperShow.ApiController;
import com.telkomsigma.pramborsshow.HelperShow.Server;
import com.telkomsigma.pramborsshow.ModelShow.ChildModel;
import com.telkomsigma.pramborsshow.ModelShow.HeaderModel;
import com.telkomsigma.pramborsshow.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;


public class CalendarViewFragment extends Fragment {

    private static final String TAG = CalendarViewFragment.class.getSimpleName();

    private ExpandableListView expandableListView;
    private ExpandListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar_view, container, false);

        expandableListView = view.findViewById(R.id.simple_expandable_listview);
        expandableListView.setGroupIndicator(null);

        dataParsing();

        return view;
    }

    private void dataParsing() {

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, Server.url_getcalendar, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                ArrayList<HeaderModel> headerList = new ArrayList<HeaderModel>();
                ArrayList<ChildModel> childList;

                try {
                    Iterator<String> key = response.keys();
                    while (key.hasNext()) {
                        String headerTitle = key.next();
                        HeaderModel hmodel = new HeaderModel();
                        hmodel.setHari(headerTitle);
                        childList = new ArrayList<ChildModel>();

                        JSONArray ja = response.getJSONArray(headerTitle);
                        for (int i = 0; i < ja.length(); i++) {
                            JSONObject jo = ja.getJSONObject(i);
                            ChildModel ch = new ChildModel();
                            ch.setTime(jo.getString(Server.TIME_CAL));
                            ch.setShows(jo.getString(Server.SHOWS_CAL));
                            ch.setInfo(jo.getString(Server.INFO_CAL));
                            ch.setImage(jo.getString(Server.IMAGE_CAL));
                            ch.setDetail(jo.getString(Server.DETAIL_CAL));
                            childList.add(ch);
                        }

                        hmodel.setItems(childList);
                        headerList.add(hmodel);

                        adapter = new ExpandListAdapter(getContext(), headerList);
                        expandableListView.setAdapter(adapter);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.d("Error ", error.toString());
            }
        });
        ApiController.getmInstance().addToRequestQueue(jsonObjReq, Server.tag_json_obj);
    }

}
