package com.example.food_waste_managment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PAdapter extends RecyclerView.Adapter<PAdapter.ViewHolder> {

    ArrayList<order> mList;
    Context context;

    public PAdapter(ArrayList<order> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.data_list,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        order vacancy1 = mList.get(position);
        holder.txtname.setText(vacancy1.getUsername());
        holder.txtaddress.setText(vacancy1.getAdderess());
        holder.txtprofile.setText(vacancy1.getNumber());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtname,txtaddress,txtprofile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtname = itemView.findViewById(R.id.txtbname);
            txtaddress = itemView.findViewById(R.id.txtaddress);
            txtprofile = itemView.findViewById(R.id.txtprofile);

        }
    }
}
