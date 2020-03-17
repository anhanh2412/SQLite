package com.example.sqlite;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<SinhVien> {
    Context context;
    int resource;
    ArrayList<SinhVien> sinhViens;
    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.sinhViens = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_listview_layout, parent, false);
        TextView text_name = convertView.findViewById(R.id.text_name);
        TextView text_namsinh = convertView.findViewById(R.id.text_namsinh);
        TextView text_gt = convertView.findViewById(R.id.text_gt);
        TextView text_school = convertView.findViewById(R.id.text_school);
        TextView text_sothich = convertView.findViewById(R.id.text_sothich);
        SinhVien sinhVien = sinhViens.get(position);
        text_name.setText(sinhVien.getHoTen());
        text_gt.setText(sinhVien.getGioiTinh()+"");
        text_namsinh.setText(sinhVien.getNamSinh());
        text_school.setText(sinhVien.getSchool());
        text_sothich.setText(sinhVien.getSoThich());
        return convertView;
    }
}
