package com.example.artikelwayang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;


public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_WAYANG = "EXTRA_WAYANG";

    ImageView ibDetail;
    TextView tvName;
    TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setTitle("Detail");

        ibDetail = findViewById(R.id.dtl_photo);
        tvName = findViewById(R.id.dtl_name);
        tvDescription = findViewById(R.id.dtl_description);

        Wayang wayang = getIntent().getParcelableExtra(EXTRA_WAYANG);

        assert wayang != null;
        Glide.with(getApplicationContext())
                .load(wayang.getPhoto())
                .into(ibDetail);

        tvName.setText(wayang.getName());
        tvDescription.setText(wayang.getWayang_detail());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent myIntent = new Intent();
            myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            finish();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
