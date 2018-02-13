package com.sandec.wakhyudi.presensirt8.model;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.sandec.wakhyudi.presensirt8.R;

/**
 * Created by wakhyudi on 28/01/18.
 */

public class Warga {
    private  int id;

    private String namaWarga;
    private String presensiWarga;
    private Boolean isChecked;
    private int state;
    private RadioButton rb;

    private RadioGroup rg;

    public Warga() {
    }

    public RadioGroup getRg() {
        return rg;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setRg(RadioGroup rg) {
        this.rg = rg;
    }

    public RadioButton getRb() {
        return rb;
    }

    public void setRb(RadioButton rb) {
        this.rb = rb;
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }

    public void setSelectedId(int selectedId) {
        this.selectedId = selectedId;
    }

    private int selectedId;

    public Warga(String namaWarga, String presensiWarga) {
        this.namaWarga = namaWarga;
        this.presensiWarga = presensiWarga;
    }

    public String getNamaWarga() {
        return namaWarga;
    }



    public String getPresensiWarga() {
        return presensiWarga;
    }

    public int getSelectedId() {
        return selectedId;
    }
}
