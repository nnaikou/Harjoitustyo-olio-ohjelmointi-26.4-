package com.example.harjoitustyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {

    private Context context;
    private ArrayList<Lutemon> lutemons = null;

    public LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        holder.lutemonName.setText(lutemons.get(position).getName() + " ("+ lutemons.get(position).getColor()+")");
        holder.lutemonAttack.setText("Hyökkäys: " + lutemons.get(position).getAttack());
        holder.lutemonDefense.setText("Puolustus: " + lutemons.get(position).getDefense());
        holder.lutemonLife.setText("Elämä: " + lutemons.get(position).getHealth() + "/" + lutemons.get(position).getMaxHealth());
        holder.lutemonExp.setText("Kokemus: " + lutemons.get(position).getExperience());
        holder.lutemonLosedFights.setText("Hävityt taistelut: "+lutemons.get(position).getLosedFights());
        holder.userIconImage.setImageResource(lutemons.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }

}


