package com.telkomsigma.pramborsshow.AdapterShow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.telkomsigma.pramborsshow.ControllerShow.DetailListViewActivity;
import com.telkomsigma.pramborsshow.ModelShow.ListModel;
import com.telkomsigma.pramborsshow.R;

import java.util.Collections;
import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.MyViewHolder> {

    private List<ListModel> listdata = Collections.emptyList();
    private Activity activity;

    public ListViewAdapter(Activity activity, List<ListModel> listdata) {
        this.listdata = listdata;
        this.activity = activity;
    }

    @Override
    public ListViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_listview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListViewAdapter.MyViewHolder holder, final int position) {
        holder.textTitle.setText(listdata.get(position).getTitle());
        Glide.with(activity).load(listdata.get(position).getImage()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, DetailListViewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title", listdata.get(position).getTitle());
                bundle.putString("info", listdata.get(position).getInfo());
                bundle.putString("image", listdata.get(position).getImage());
                bundle.putString("detail", listdata.get(position).getDetail());
                intent.putExtras(bundle);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textTitle;
        private ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.textTitleListView);
            imageView = itemView.findViewById(R.id.imageListView);
        }
    }
}
