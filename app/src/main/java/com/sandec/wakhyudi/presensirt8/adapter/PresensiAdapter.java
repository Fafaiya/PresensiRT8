package com.sandec.wakhyudi.presensirt8.adapter;

import android.content.Context;
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

import java.util.List;

/**
 * Created by wakhyudi on 28/01/18.
 */

public class PresensiAdapter extends RecyclerView.Adapter<PresensiAdapter.PresensiViewHolder> {
    private Context context;
    private List<Warga>listPresensi;
    private RadioButton rbLastChecked = null;
    private RadioGroup lastCheckedRadioGroup = null;
    //CheckBox cbPresensi;
    public PresensiAdapter(Context context, List<Warga> listPresensi) {
        this.context = context;
        this.listPresensi = listPresensi;
    }

    @Override
    public PresensiAdapter.PresensiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_warga,parent,false);
        return new PresensiViewHolder(itemView);
    }

    public static class PresensiViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaWarga;
        CheckBox cbPresensi;
//        RadioGroup rgPresensiWarga;
//        RadioButton rbH,rbI,rbA;
        public PresensiViewHolder(final View itemView) {
            super(itemView);
            tvNamaWarga = (TextView)itemView.findViewById(R.id.tv_item_warga_nama);
            cbPresensi = (CheckBox)itemView.findViewById(R.id.cb_item_warga);
//            rgPresensiWarga = (RadioGroup)itemView.findViewById(R.id.rg_item_warga_kehadiran);
//            rbH = (RadioButton)itemView.findViewById(R.id.rb_hadir);
//            rbI = (RadioButton)itemView.findViewById(R.id.rb_ijin);
//            rbA = (RadioButton)itemView.findViewById(R.id.rb_alpa);
//            cbPresensi.setOnCheckedChangeListener(null);
//
//            cbPresensi.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    cbPresensi.setChecked(true);
//                    notifyDataSetChanged();
//                }
//            });



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
    public void onBindViewHolder(PresensiAdapter.PresensiViewHolder holder, int position) {
        //holder.tvNamaWarga.setText(listPresensi.get(position).getNamaWarga());
        Warga warga = listPresensi.get(position);
        initView(warga, holder, position);

    }
    private void initView(Warga warga, PresensiAdapter.PresensiViewHolder holder, int position) {
        ((PresensiViewHolder)holder).tvNamaWarga.setText(warga.getNamaWarga());
        ((PresensiViewHolder)holder).cbPresensi.setChecked(warga.getChecked());
        ((PresensiViewHolder)holder).cbPresensi.setTag(new Integer(position));
        ((PresensiViewHolder)holder).cbPresensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cb = (CheckBox)v;
                int clickedPos = ((Integer)cb.getTag()).intValue();
                listPresensi.get(clickedPos).setChecked(cb.isChecked());
                notifyDataSetChanged();
            }
        });
    }
        //holder.rgPresensiWarga.setId(position);


//        holder.rgPresensiWarga.setOnCheckedChangeListener(onCheckedChangeListener);

//        View.OnClickListener rbClick = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                RadioButton checked_rb = (RadioButton) v;
//                if(rbLastChecked != null){
//                    rbLastChecked.setChecked(false);
//                }
//                rbLastChecked = checked_rb;
//            }
//        };
//
//        holder.rbH.setOnClickListener(rbClick);
//        holder.rbI.setOnClickListener(rbClick);
//        holder.rbA.setOnClickListener(rbClick);

//        holder.rgPresensiWarga.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if(checkedId!= -1){
//                    RadioGroup rg = listPresensi.get(position).getRg();
//                }
//
//            }
//        });

//        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (buttonView.isPressed()){
//                    Toast.makeText(context, ""+buttonView.getId(), Toast.LENGTH_SHORT).show();
////                    switch (buttonView.getId()){
////                    case R.id.rb_hadir:
////                        holder.rbH.setChecked(true);
////                        break;
////                    case R.id.rb_ijin:
////                        holder.rbI.setChecked(true);
////                        break;
////                    case R.id.rb_alpa:
////                        holder.rbA.setChecked(true);
////                        break;
////                    }
//                }
//                else{
//                    holder.rgPresensiWarga.clearCheck();
//                }
//            }
//        };
//        //holder.rgPresensiWarga.setOnCheckedChangeListener(null);
//
//
//        holder.rbH.setOnCheckedChangeListener(onCheckedChangeListener);
//        holder.rbI.setOnCheckedChangeListener(onCheckedChangeListener);
//        holder.rbA.setOnCheckedChangeListener(onCheckedChangeListener);


//        holder.rgPresensiWarga.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, ""+v.getId(), Toast.LENGTH_SHORT).show();
//                switch (v.getId()){
//                    case R.id.rb_hadir:
//                        holder.rbH.setChecked(true);
//                        break;
//                    case R.id.rb_ijin:
//                        holder.rbI.setChecked(true);
//                        break;
//                    case R.id.rb_alpa:
//                        holder.rbA.setChecked(true);
//                        break;
//                }
//            }
//        });

//        holder.rgPresensiWarga.setOnCheckedChangeListener(null);
//        holder.rgPresensiWarga.clearCheck();
//        holder.rgPresensiWarga.setOnCheckedChangeListener(onCheckedChangeListener);





    @Override
    public int getItemCount() {
        return listPresensi.size();
    }


}
