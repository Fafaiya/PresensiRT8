package com.sandec.wakhyudi.presensirt8.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.sandec.wakhyudi.presensirt8.R;
import com.sandec.wakhyudi.presensirt8.adapter.PresensiAdapter;
import com.sandec.wakhyudi.presensirt8.model.ResponServer;
import com.sandec.wakhyudi.presensirt8.model.Warga;
import com.sandec.wakhyudi.presensirt8.network.ServiceClient;
import com.sandec.wakhyudi.presensirt8.network.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresensiActivity extends AppCompatActivity {
List<Warga>listPresensi = new ArrayList<>();
RecyclerView rvPresensi;
String[] namaWarga = {"Adi",
        "Adib",
        "Ahmadun",
        "Andi",
        "Angga",
        "Ari",
        "Arifin",
        "Deny",
        "Djuamin",
        "Edi",
        "Feri",
        "Hj Parno",
        "Pak De Toto",
        "Panji",
        "Parno B",
        "Rizal",
        "Sutarso",
        "Suwanto",
        "Toto",
        "Udin",
        "Wakhyudi",
        "Yoyok",
        "Yudi",
        "Yuli"};
Bundle b;
int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presensi);

        rvPresensi = (RecyclerView)findViewById(R.id.rv_presensi);
        rvPresensi.setLayoutManager(new LinearLayoutManager(this));

        b = getIntent().getExtras();

        for (int i = 0; i <namaWarga.length ; i++) {

            Warga warga = new Warga(namaWarga[i],"kosong");
            warga.setId(i);

            listPresensi.add(warga);

        }

        rvPresensi.setAdapter(new PresensiAdapter(this,listPresensi));

    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        rvPresensi.getChildAt(0).findViewById(R.id.rg_item_warga_kehadiran).
//    }

//    public void getPresensi(View view) {
//        final ProgressDialog pd = new ProgressDialog(this);
//        pd.setMessage("load data ...");
//        pd.show();
//
//        List<String>listStatusPresensi = new ArrayList<>();
//        String[]absen;
//        int jmlWarga = rvPresensi.getChildCount();
//
//
//        for (int i = 0; i <jmlWarga ; i++) {
//            RadioGroup rgWarga = rvPresensi.getChildAt(i).findViewById(R.id.rg_item_warga_kehadiran);
//            int selectedRadioButtonId = rgWarga.getCheckedRadioButtonId();
//
//            RadioButton rbPresensi = rvPresensi.getChildAt(i).findViewById(selectedRadioButtonId);
//            String statusPresensi = rbPresensi.getText().toString();
//            listStatusPresensi.add(statusPresensi);
//
//
//        }
//
//
//       // Log.d("data", "onResponse: "+listStatusPresensi);
//        ServiceClient service = ServiceGenerator.createService(ServiceClient.class);
//        String bulan = b.getString("bulan");
//        Call<ResponServer>sendData = service.sendPresensi("insert","2018",bulan,listStatusPresensi);
//
//
//        sendData.enqueue(new Callback<ResponServer>() {
//            @Override
//            public void onResponse(Call<ResponServer> call, Response<ResponServer> response) {
//                pd.dismiss();
//                String hasil = response.body().getHasil();
//                Log.d("data", "onResponse: "+hasil);
//               // Toast.makeText(PresensiActivity.this, ""+hasil, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<ResponServer> call, Throwable t) {
//                pd.dismiss();
//                Log.d("data", "onResponse: "+t.getMessage());
//               // Toast.makeText(PresensiActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        //Toast.makeText(this, ""+listStatusPresensi, Toast.LENGTH_SHORT).show();
//
//    }
}
