package com.sandec.wakhyudi.presensirt8.model;

import android.widget.RadioGroup;

/**
 * Created by wakhyudi on 28/01/18.
 */

public class Warga {
    private  int id;
    private String namaWarga;
    private String presensiWarga;
    private Boolean isChecked = false;

    public Warga() {
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
