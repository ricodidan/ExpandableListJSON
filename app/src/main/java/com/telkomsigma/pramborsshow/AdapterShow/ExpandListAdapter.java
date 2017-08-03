package com.telkomsigma.pramborsshow.AdapterShow;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.telkomsigma.pramborsshow.ControllerShow.DetailListViewActivity;
import com.telkomsigma.pramborsshow.ModelShow.ChildModel;
import com.telkomsigma.pramborsshow.ModelShow.HeaderModel;
import com.telkomsigma.pramborsshow.R;

import java.util.ArrayList;

/**
 * Created by user on 21/07/2017.
 */

public class ExpandListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<HeaderModel> header;

    public ExpandListAdapter(Context context, ArrayList<HeaderModel> header) {
        this.context = context;
        this.header = header;
    }

    @Override
    public int getGroupCount() {
        return header.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<ChildModel> chList = header.get(groupPosition).getItems();
        return chList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return header.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<ChildModel> chList = header.get(groupPosition).getItems();
        return chList.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.header_list_item, viewGroup, false);
        }

        HeaderModel headerModel = (HeaderModel) getGroup(groupPosition);
        TextView textHeader = view.findViewById(R.id.textHeader);
        textHeader.setText(headerModel.getHari());

        if (b) {
            textHeader.setTypeface(null, Typeface.BOLD);
            textHeader.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_up, 0);
        } else {
            textHeader.setTypeface(null, Typeface.NORMAL);
            textHeader.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_down, 0);
        }

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View view, ViewGroup viewGroup) {

        final ChildModel childModel = (ChildModel) getChild(groupPosition, childPosition);

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.child_list_item, viewGroup, false);
        }

        ImageView imageView = view.findViewById(R.id.imageFotoChild);
        TextView textWaktu = view.findViewById(R.id.textWaktu);
        final TextView textShows = view.findViewById(R.id.textNama);
        final TextView textInfo = view.findViewById(R.id.textKeterangan);

        Glide.with(context).load(childModel.getImage()).into(imageView);
        textWaktu.setText(childModel.getTime());
        textShows.setText(childModel.getShows());
        textInfo.setText(childModel.getInfo());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailListViewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title", textShows.getText().toString());
                bundle.putString("info", textInfo.getText().toString());
                bundle.putString("image", childModel.getImage());
                bundle.putString("detail", childModel.getDetail());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
