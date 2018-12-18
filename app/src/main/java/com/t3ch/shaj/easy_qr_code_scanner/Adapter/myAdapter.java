package com.t3ch.shaj.easy_qr_code_scanner.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.t3ch.shaj.easy_qr_code_scanner.Model.ListItems;
import com.t3ch.shaj.easy_qr_code_scanner.R;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myAdapterViewHolder> {

    List<ListItems> listItemsArrayList;
    Context context;

    public myAdapter(List<ListItems> listItemsArrayList, Context context) {
        this.listItemsArrayList = listItemsArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public myAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_layout, viewGroup, false);

        return new myAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myAdapterViewHolder myAdapterViewHolder, int i) {

        ListItems listItems = listItemsArrayList.get(i);
        myAdapterViewHolder.textViewType.setText(listItems.getType());
        myAdapterViewHolder.textViewCode.setText(listItems.getCode());

        Linkify.addLinks(myAdapterViewHolder.textViewCode, Linkify.ALL);


    }

    @Override
    public int getItemCount() {
        return listItemsArrayList.size();
    }

    public class myAdapterViewHolder extends RecyclerView.ViewHolder

    {
        TextView textViewCode, textViewType;
        CardView cardView;

        public myAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewCode = itemView.findViewById(R.id.TV1);
            textViewType = itemView.findViewById(R.id.TV2);
            cardView = itemView.findViewById(R.id.CVid);


        }


    }


}
