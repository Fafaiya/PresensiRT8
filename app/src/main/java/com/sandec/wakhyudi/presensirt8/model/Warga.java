package com.sandec.wakhyudi.presensirt8.model;

import android.content.SharedPreferences;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.sandec.wakhyudi.presensirt8.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wakhyudi on 28/01/18.
 */

public class Warga {

    private String namaWarga;
    private String presensiWarga;
    private String customTag;
    private int selectedRadioButtonId;
    private String status1;
    private String status2;
    private String status3;
    private String finalPresensi;




    public Warga(String namaWarga, String presensiWarga, String status1, String status2, String status3) {
        this.namaWarga = namaWarga;
        this.presensiWarga = presensiWarga;
        this.status1 = status1;
        this.status2 = status2;
        this.status3 = status3;
    }

    public String getFinalPresensi() {
        return finalPresensi;
    }

    public void setFinalPresensi(String finalPresensi) {
        this.finalPresensi = finalPresensi;
    }

    public int getSelectedRadioButtonId() {
        return selectedRadioButtonId;
    }

    public void setSelectedRadioButtonId(int selectedRadioButtonId) {
        this.selectedRadioButtonId = selectedRadioButtonId;
    }

    public void setCustomTag(String customTag) {
        this.customTag = customTag;
    }

    public String getStatus1() {
        return status1;
    }

    public String getStatus2() {
        return status2;
    }

    public String getStatus3() {
        return status3;
    }

    public String getNamaWarga() {
        return namaWarga;
    }



}
