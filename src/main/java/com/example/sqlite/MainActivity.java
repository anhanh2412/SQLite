package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edit_name, edit_namsinh, edit_school;
    Button bt_nhaplieu, bt_nhaplai, bt_xemds;
    RadioButton rdbt_nam, rdbt_nu;
    CheckBox checkbox_thethao, checkbox_dulich, checkbox_docsach;
    SQLiteDatabase sql;
    Database database;
    ArrayList<SinhVien> sinhViens;
    CustomAdapter adapter;
    ListView list_ds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWidth();
        database = new Database(this);
        evenButtonNhapLai();
        evenButtonNhapLieu();
        evenXemDS();
    }

    void setWidth(){
        edit_name = findViewById(R.id.edit_name);
        edit_namsinh = findViewById(R.id.edit_namsinh);
        edit_school = findViewById(R.id.edit_school);
        bt_nhaplai = findViewById(R.id.bt_nhaplai);
        bt_nhaplieu = findViewById(R.id.bt_nhaplieu);
        bt_xemds = findViewById(R.id.bt_xemds);
        rdbt_nam = findViewById(R.id.rdbt_nam);
        rdbt_nu = findViewById(R.id.rdbt_nu);
        checkbox_docsach = findViewById(R.id.checkbox_docsach);
        checkbox_dulich = findViewById(R.id.checkbox_dulich);
        checkbox_thethao = findViewById(R.id.checkbox_thethao);
        list_ds = findViewById(R.id.list_ds);
        sinhViens = new ArrayList<>();
        adapter = new CustomAdapter(MainActivity.this,R.layout.activity_main, sinhViens);
        list_ds.setAdapter(adapter);
    }

    void evenButtonNhapLai(){
        bt_nhaplai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_name.setText("");
                edit_namsinh.setText("");
                edit_school.setText("");
                rdbt_nam.setChecked(true);
                rdbt_nu.setChecked(false);
                checkbox_docsach.setChecked(false);
                checkbox_dulich.setChecked(false);
                checkbox_thethao.setChecked(false);
            }
        });
    }

    void evenButtonNhapLieu(){
        bt_nhaplieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit_name.getText().toString();
                String namsinh = edit_namsinh.getText().toString();
                String truong = edit_school.getText().toString();
                String sothich = "";
                int gt;
                if(checkbox_thethao.isChecked()){
                    sothich += ","+checkbox_thethao.getText().toString();
                }
                if(checkbox_dulich.isChecked()){
                    sothich += ","+checkbox_dulich.getText().toString();
                }
                if(checkbox_docsach.isChecked()){
                    sothich += ","+checkbox_docsach.getText().toString();
                }
                if(rdbt_nu.isChecked()){
                    gt = 1;
                }else gt = 0;

                SinhVien sv = new SinhVien(name,gt,namsinh,sothich,truong);
                if(sv != null) {
                    Log.d(null,"haha");
                    database.khongtraKQ(sv);
                    Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    void evenXemDS(){
        bt_xemds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = database.traKQ("SELECT * FROM SinhVien");
                Log.d("TAG", "onClick: ");
                while(cursor.moveToNext()){
                    String id = cursor.getString(0);
                    String name = cursor.getString(1);
                    int gt = cursor.getInt(2);
                    String namsinh = cursor.getString(3);
                    String sothich = cursor.getString(4);
                    String truong = cursor.getString(5);
                    Log.d("TAG", "onClick: "+namsinh);
                    SinhVien sv = new SinhVien(id,name,namsinh,truong,gt,sothich);
                    sinhViens.add(sv);
                }
                adapter.notifyDataSetChanged();
            }
        });
    }
}