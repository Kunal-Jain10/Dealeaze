package com.example.dealeaze;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BuyViewHolder extends RecyclerView.ViewHolder {

    TextView textViewProduct,textViewDesc;

    public BuyViewHolder(@NonNull View itemView) {
        super(itemView);

        textViewProduct = itemView.findViewById(R.id.buy_productRcView);
        textViewDesc = itemView.findViewById(R.id.buy_descRcView);
    }
}
