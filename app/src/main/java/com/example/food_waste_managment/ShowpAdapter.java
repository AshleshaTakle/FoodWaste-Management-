package com.example.food_waste_managment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ShowpAdapter extends RecyclerView.Adapter<ShowpAdapter.ViewHolder> {


    ArrayList<Ourproduct> mList;
    private RecyclerViewClickListener listener;

    public ShowpAdapter(ArrayList<Ourproduct> mList, RecyclerViewClickListener listener) {
        this.mList = mList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.useritem,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Ourproduct vacancy1 = mList.get(position);
        holder.txtbname.setText(vacancy1.getFarmername());
        holder.txtaddress.setText(vacancy1.getProductname());
        holder.txttype.setText(vacancy1.getPrice());
        Glide.with(holder.img1.getContext()).load(vacancy1.getImageurl()).into(holder.img1);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


    ImageView img1;
    TextView txtbname,txtaddress,txttype;



    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        img1 =itemView.findViewById(R.id.img1);
        txtbname = itemView.findViewById(R.id.nametext);
        txtaddress = itemView.findViewById(R.id.coursetext);
        txttype = itemView.findViewById(R.id.emailtext);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        listener.onClick(v,getAdapterPosition());
    }
}
}
