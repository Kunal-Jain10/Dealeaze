package com.example.dealeaze;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BuyFragment extends Fragment {

    RecyclerView recyclerView;
    DatabaseReference buy_dataBaseReference;
    FirebaseRecyclerOptions<SellHelper>options;
    FirebaseRecyclerAdapter<SellHelper,BuyViewHolder> adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy, container, false);
        buy_dataBaseReference = FirebaseDatabase.getInstance().getReference().child("Items");
        recyclerView = (RecyclerView)view.findViewById(R.id.buy_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        options = new FirebaseRecyclerOptions.Builder<SellHelper>().setQuery(buy_dataBaseReference,SellHelper.class).build();
        adapter = new FirebaseRecyclerAdapter<SellHelper, BuyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull BuyViewHolder holder, int position, @NonNull SellHelper model) {
                holder.textViewProduct.setText(model.getProduct());
                holder.textViewDesc.setText(model.getDescription());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(),buy_details.class);
                        intent.putExtra("dProduct",model.getProduct());
                        intent.putExtra("dDesc",model.getDescription());
                        intent.putExtra("dPrice",model.getPrice());
                        intent.putExtra("dContact",model.getContact());
                        startActivity(intent);
                    }
                });
            }

            @NonNull
            @Override
            public BuyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.buy_cardview,parent,false);
                return new BuyViewHolder(view);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
        return view;
    }
}
