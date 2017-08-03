package com.telkomsigma.pramborsshow.AdapterShow;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.telkomsigma.pramborsshow.ModelShow.CalendarModel;
import com.telkomsigma.pramborsshow.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by user on 20/07/2017.
 */

public class CalendarViewAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<CalendarModel> listdataHeader;
    private HashMap<CalendarModel, List<CalendarModel>> listdataChild;

    public CalendarViewAdapter(Context context, List<CalendarModel> listdataHeader,
                               HashMap<CalendarModel, List<CalendarModel>> listdataChild) {
        this.context = context;
        this.listdataHeader = listdataHeader;
        this.listdataChild = listdataChild;
    }

    @Override
    public int getGroupCount() {
        return listdataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listdataChild.get(this.listdataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listdataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listdataChild.get(this.listdataHeader.get(groupPosition)).get(childPosition);
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
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.header_list_item, viewGroup, false);
        }

        TextView textHeader = view.findViewById(R.id.textHeader);
        textHeader.setText(listdataHeader.get(groupPosition).getHari());

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

        CalendarModel calendarModel = (CalendarModel) getChild(groupPosition, childPosition);

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.child_list_item, viewGroup, false);
        }

        ImageView imageView = view.findViewById(R.id.imageFotoChild);
        TextView textWaktu = view.findViewById(R.id.textWaktu);
        TextView textNama = view.findViewById(R.id.textNama);
        TextView textKet = view.findViewById(R.id.textKeterangan);

        imageView.setImageResource(calendarModel.getImage());
        textWaktu.setText(calendarModel.getWaktu());
        textNama.setText(calendarModel.getNama());
        textKet.setText(calendarModel.getKet());

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
