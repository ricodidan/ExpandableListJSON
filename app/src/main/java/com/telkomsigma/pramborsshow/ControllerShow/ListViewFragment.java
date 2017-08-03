package com.telkomsigma.pramborsshow.ControllerShow;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.telkomsigma.pramborsshow.AdapterShow.ListViewAdapter;
import com.telkomsigma.pramborsshow.HelperShow.ApiController;
import com.telkomsigma.pramborsshow.HelperShow.Server;
import com.telkomsigma.pramborsshow.ModelShow.ListModel;
import com.telkomsigma.pramborsshow.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class ListViewFragment extends Fragment {

    private static final String TAG = ListViewFragment.class.getSimpleName();

    private List<ListModel> listdata = new ArrayList<>();
    private RecyclerView recyclerView;
    private ListViewAdapter listViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_view, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewListView);

        //listdata = ListModel.getListViewAll();

        getSelectAllData();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        listViewAdapter = new ListViewAdapter(getActivity(), listdata);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(listViewAdapter);

        return view;

    }

    private void getSelectAllData() {
        listdata.clear();

        JsonArrayRequest jar = new JsonArrayRequest(Server.url_getshow, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject job = response.getJSONObject(i);
                        ListModel model = new ListModel();
                        model.setId(Integer.parseInt(job.getString(Server.ID)));
                        model.setTitle(job.getString(Server.NAME));
                        model.setInfo(job.getString(Server.INFO));
                        model.setImage(job.getString(Server.IMAGE));
                        model.setDetail(job.getString(Server.DETAIL));
                        listdata.add(model);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                listViewAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e(TAG, "Error " + error.getMessage());
            }
        });

        ApiController.getmInstance().addToRequestQueue(jar);
    }

}
