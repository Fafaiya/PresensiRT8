package com.sandec.wakhyudi.presensirt8.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sandec.wakhyudi.presensirt8.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void presensiWarga(View view) {
        startActivity(new Intent(this,PilihBulanActivity.class));
        finish();
    }
}
