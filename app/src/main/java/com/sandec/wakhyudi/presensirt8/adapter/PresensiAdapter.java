package com.sandec.wakhyudi.presensirt8.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sandec.wakhyudi.presensirt8.R;
import com.sandec.wakhyudi.presensirt8.activities.PresensiActivity;
import com.sandec.wakhyudi.presensirt8.model.Warga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wakhyudi on 28/01/18.
 */

public class PresensiAdapter extends RecyclerView.Adapter<PresensiAdapter.PresensiViewHolder> {
    String[] nama = PresensiActivity.namaWarga;
    private Context context;
    private List<Warga> listPresensi;

    public static List<String>listStatus = new ArrayList<>();

    //CheckBox cbPresensiH;
    public PresensiAdapter(Context context, List<Warga> listPresensi) {
        this.context = context;
        this.listPresensi = listPresensi;

    }

    @Override
    public PresensiAdapter.PresensiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_warga, parent, false);
        return new PresensiViewHolder(itemView);
    }

    public class PresensiViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaWarga;
        CheckBox cbPresensiH, cbPresensiI, cbPresensiA;
        RadioGroup rgPresensiWarga;
        RadioButton rbH, rbI, rbA;


        public PresensiViewHolder(View itemView) {
            super(itemView);
            tvNamaWarga = (TextView) itemView.findViewById(R.id.tv_item_warga_nama);
            rgPresensiWarga = (RadioGroup) itemView.findViewById(R.id.rg_item_warga_kehadiran);
            rbH = (RadioButton) itemView.findViewById(R.id.rb_hadir);
            rbI = (RadioButton) itemView.findViewById(R.id.rb_ijin);
            rbA = (RadioButton) itemView.findViewById(R.id.rb_alpa);


//            CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                    if(buttonView.isPressed()){
//                        int selectedID = rgPresensiWarga.getCheckedRadioButtonId();
//                        RadioButton rb = (RadioButton)itemView.findViewById(selectedID);
//                        //String hasil = rb.getText().toString();
//                        Toast.makeText(context, "coba", Toast.LENGTH_SHORT).show();
//                        rgPresensiWarga.setVisibility(View.GONE);
//
//                    }
//                }
//            };
//
//            rbH.setOnCheckedChangeListener(onCheckedChangeListener);
//            rbI.setOnCheckedChangeListener(onCheckedChangeListener);
//            rbA.setOnCheckedChangeListener(onCheckedChangeListener);

        }
    }

    @Override
    public void onBindViewHolder(final PresensiAdapter.PresensiViewHolder holder, final int position) {



        holder.tvNamaWarga.setText(listPresensi.get(position).getNamaWarga());
        holder.rbH.setText(listPresensi.get(position).getStatus1());
        holder.rbI.setText(listPresensi.get(position).getStatus2());
        holder.rbA.setText(listPresensi.get(position).getStatus3());

        holder.rgPresensiWarga.setTag(position);

        holder.rgPresensiWarga.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1) {

                    int radioButtonID = group.getCheckedRadioButtonId();
                    int clickedPos = (Integer) group.getTag();
                    listPresensi.get(clickedPos).setSelectedRadioButtonId(radioButtonID);

                    //memfilter keadan radioButtonid nya, karena menghasilkan 0 juga
                    if(radioButtonID>0){
                        RadioButton radioButton = holder.rgPresensiWarga.findViewById(radioButtonID);
                        listPresensi.get(clickedPos).setFinalPresensi(radioButton.getText().toString());
                    }


                }


            }

        });

        holder.rgPresensiWarga.check(listPresensi.get(position).getSelectedRadioButtonId());


    }



    @Override
    public int getItemCount() {
        return listPresensi.size();
    }


}

//ini untuk checkbox
////        ((PresensiViewHolder)holder).cbPresensiH.setChecked(warga.getChecked());
////        ((PresensiViewHolder)holder).cbPresensiH.setTag(position);
////        ((PresensiViewHolder)holder).cbPresensiH.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                CheckBox cb = (CheckBox) v;
////                int clickedPos = ((Integer)cb.getTag()).intValue();
////                listPresensi.get(clickedPos).setChecked(cb.isChecked());
////                notifyDataSetChanged();
////            }
////        });
//
