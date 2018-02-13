package com.sandec.wakhyudi.presensirt8.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.sandec.wakhyudi.presensirt8.R;
import com.sandec.wakhyudi.presensirt8.model.Warga;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wakhyudi on 28/01/18.
 */

public class PresensiAdapter extends RecyclerView.Adapter<PresensiAdapter.PresensiViewHolder> {
    private Context context;
    private List<Warga> listPresensi;
    private RadioButton rbLastChecked = null;
    private RadioGroup lastCheckedRadioGroup = null;
    private int[] state;

    //CheckBox cbPresensiH;
    public PresensiAdapter(Context context, List<Warga> listPresensi) {
        this.context = context;
        this.listPresensi = listPresensi;

        this.state = new int[listPresensi.size()];
        Arrays.fill(state, -1);
    }

    @Override
    public PresensiAdapter.PresensiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_warga, parent, false);
        return new PresensiViewHolder(itemView);
    }

    public static class PresensiViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaWarga;
        CheckBox cbPresensiH, cbPresensiI, cbPresensiA;
        RadioGroup rgPresensiWarga;
        RadioButton rbH, rbI, rbA;

        public PresensiViewHolder(final View itemView) {
            super(itemView);
            tvNamaWarga = (TextView) itemView.findViewById(R.id.tv_item_warga_nama);
//            cbPresensiH = (CheckBox)itemView.findViewById(R.id.cbH_item_warga);
//            cbPresensiI = (CheckBox)itemView.findViewById(R.id.cbI_item_warga);
//            cbPresensiA = (CheckBox)itemView.findViewById(R.id.cbA_item_warga);
            rgPresensiWarga = (RadioGroup) itemView.findViewById(R.id.rg_item_warga_kehadiran);
            rbH = (RadioButton) itemView.findViewById(R.id.rb_hadir);
            rbI = (RadioButton) itemView.findViewById(R.id.rb_ijin);
            rbA = (RadioButton) itemView.findViewById(R.id.rb_alpa);
//            cbPresensiH.setOnCheckedChangeListener(null);
//
//            cbPresensiH.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    cbPresensiH.setChecked(true);
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
    public void onBindViewHolder(final PresensiAdapter.PresensiViewHolder holder, int position) {
        holder.tvNamaWarga.setText(listPresensi.get(position).getNamaWarga());

        //holder.rbA.setChecked(true);
//        holder.rbA.setChecked(false);
//        holder.rbI.setChecked(false);
//        holder.rbH.setChecked(false);

        holder.rbH.setTag(holder.rgPresensiWarga.getCheckedRadioButtonId()+position);
        //holder.rbH.setChecked(false);
        holder.rbH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb = (RadioButton)v;
                int clickedPos = ((Integer)rb.getTag()).intValue();
                listPresensi.get(clickedPos).setChecked(true);
                notifyDataSetChanged();
            }
        });

        holder.rbI.setTag(position);
        holder.rbI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb = (RadioButton)v;
                int clickedPos = ((Integer)rb.getTag()).intValue();
                listPresensi.get(clickedPos).setChecked(rb.isChecked());
                notifyDataSetChanged();
            }
        });

        holder.rbA.setTag(position);
        holder.rbA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb = (RadioButton)v;
                int clickedPos = ((Integer)rb.getTag()).intValue();
                listPresensi.get(clickedPos).setChecked(rb.isChecked());
                notifyDataSetChanged();
            }
        });




//        holder.rbH.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listPresensi.get(position).setState(0);
//                setRadio(holder, listPresensi.get(position).getState());
//            }
//        });
//
//        holder.rbI.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listPresensi.get(position).setState(1);
//                setRadio(holder, listPresensi.get(position).getState());
//            }
//        });
//
//        holder.rbA.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listPresensi.get(position).setState(2);
//                setRadio(holder, listPresensi.get(position).getState());
//            }
//        });

//        setRadio(holder,listPresensi.get(position).getState());
        //initView(warga, holder, position);

    }

//    private void setRadio(PresensiViewHolder holder, int selection) {
//        System.out.println("SELECT:" + selection);
//        RadioButton rbH = holder.rbH;
//        RadioButton rbI = holder.rbI;
//        RadioButton rbA = holder.rbA;
//
//
//        if (selection == 0) rbH.setChecked(true);
//        if (selection == 1) rbI.setChecked(true);
//        if (selection == 2) rbA.setChecked(true);
//
//
//    }
//
//    private void initView(final Warga warga, PresensiAdapter.PresensiViewHolder holder, int position) {
//        holder.tvNamaWarga.setText(warga.getNamaWarga());
//        holder.rgPresensiWarga.setTag(position);
//        holder.rbH.setTag(position);
//        holder.rbI.setTag(position);
//        holder.rbA.setTag(position);
//
//        holder.rgPresensiWarga.setOnCheckedChangeListener(null);
//        //holder.rgPresensiWarga.clearCheck();
//        holder.rgPresensiWarga.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                RadioGroup rg = (RadioGroup) v;
//
//                int selectedId = rg.getCheckedRadioButtonId();
//                RadioButton rb = v.findViewById(selectedId);
//
//                warga.setRg(rg);
//                warga.setRb(rb);
////                   rb.setChecked(false);
//                int clickedPos = ((Integer) rg.getTag()).intValue();
//                //listPresensi.get(clickedPos).getRg().getCheckedRadioButtonId();
//                listPresensi.get(clickedPos).getRb().setChecked(true);
//                notifyDataSetChanged();
//            }
//        });
//    }
//
//
//
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
//    }
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
        public int getItemCount () {
            return listPresensi.size();
        }



}
