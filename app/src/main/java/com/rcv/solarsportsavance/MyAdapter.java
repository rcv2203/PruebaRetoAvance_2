package com.rcv.solarsportsavance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<MyItem> itemList;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(MyItem item);
    }

    public MyAdapter(List<MyItem> itemList, OnItemClickListener onItemClickListener) {
        this.itemList = itemList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyItem item = itemList.get(position);
        holder.textViewName.setText(item.getName());
        holder.textViewConsumoMensual.setText(String.valueOf(item.getConsumoMensual()));
        holder.textViewConsumoAnual.setText(String.valueOf(item.getConsumoAnual()));
        holder.textViewConsumoHora.setText(String.valueOf(item.getConsumoPorHora()));
        holder.textViewNumeroPaneles.setText(String.valueOf(item.getNumeroDePaneles()));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewConsumoMensual;
        TextView textViewConsumoAnual;
        TextView textViewConsumoHora;
        TextView textViewNumeroPaneles;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewConsumoMensual = itemView.findViewById(R.id.textViewConsumoMensual);
            textViewConsumoAnual = itemView.findViewById(R.id.textViewConsumoAnual);
            textViewConsumoHora = itemView.findViewById(R.id.textViewConsumoHora);
            textViewNumeroPaneles = itemView.findViewById(R.id.textViewNumeroPaneles);

        }
    }
}