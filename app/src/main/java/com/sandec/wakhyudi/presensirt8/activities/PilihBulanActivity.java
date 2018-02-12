package com.sandec.wakhyudi.presensirt8.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.sandec.wakhyudi.presensirt8.R;

@SuppressWarnings("ALL")
public class PilihBulanActivity extends AppCompatActivity {
    Spinner spBulan;
    String[] bulan = {"Januari","Februari","Maret","April",
    "Mei","Juni","Juli","Agustus","September","Oktober","November","Desember"};
    String pilihanBulan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_bulan);
        spBulan = (Spinner)findViewById(R.id.sp_bulan);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,bulan);
        spBulan.setAdapter(arrayAdapter);

        spBulan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pilihanBulan = bulan[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void kirimBulanPresensi(View view) {
        //String pilihanBulan = spBulan.getOnItemSelectedListener().toString();
        //Toast.makeText(this, ""+pilihanBulan, Toast.LENGTH_SHORT).show();
        Bundle b = new Bundle();
        b.putString("bulan",pilihanBulan);
        Intent intent = new Intent(this,PresensiActivity.class);
        intent.putExtras(b);
        startActivity(intent);
        finish();

    }
}
