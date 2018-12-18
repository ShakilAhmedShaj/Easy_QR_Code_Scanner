package com.t3ch.shaj.easy_qr_code_scanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.t3ch.shaj.easy_qr_code_scanner.Databases.dbHelper;
import com.t3ch.shaj.easy_qr_code_scanner.Model.ListItems;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<ListItems> arrayList;

    dbHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RVid);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        helper = new dbHelper(this);

        //fetch DB


        arrayList = helper.getAllInfo();

        if (arrayList.size() > 0) {

        } else {
            Toast.makeText(getApplicationContext(), "NO DATA FOUND !!", Toast.LENGTH_LONG).show();
        }


    }
}
