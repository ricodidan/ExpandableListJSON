package com.telkomsigma.pramborsshow.ControllerShow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.telkomsigma.pramborsshow.R;

public class DetailListViewActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView tDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tDetail = (TextView) findViewById(R.id.textDetail);
        imageView = (ImageView) findViewById(R.id.imageFotoListViewDetail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
        getSupportActionBar().setTitle(bundle.getString("title"));
        Glide.with(DetailListViewActivity.this).load(bundle.getString("image")).into(imageView);
        tDetail.setText(bundle.getString("info") + "\n\n" +
                bundle.getString("detail"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_detail_list_view, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
