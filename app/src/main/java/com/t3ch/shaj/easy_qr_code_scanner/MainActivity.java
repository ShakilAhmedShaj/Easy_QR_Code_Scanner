package com.t3ch.shaj.easy_qr_code_scanner;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import com.t3ch.shaj.easy_qr_code_scanner.Adapter.myAdapter;
import com.t3ch.shaj.easy_qr_code_scanner.Databases.dbHelper;
import com.t3ch.shaj.easy_qr_code_scanner.Model.ListItems;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<ListItems> arrayList;

    dbHelper helper;

    myAdapter myAdapter;


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


            myAdapter = new myAdapter(arrayList, this);
            recyclerView.setAdapter(myAdapter);

        } else {
            Toast.makeText(getApplicationContext(), "NO DATA FOUND !!", Toast.LENGTH_LONG).show();
        }

        //swipe action delete

        new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                return 0;
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

                final int position = viewHolder.getAdapterPosition();
                ListItems listItems = arrayList.get(position);

                //remove data

                helper.deleteRow(listItems.getId());

                arrayList.remove(position);

                myAdapter.notifyItemRemoved(position);
                myAdapter.notifyItemRangeChanged(position,arrayList.size());


            }
        }).attachToRecyclerView(recyclerView);


    }
}
