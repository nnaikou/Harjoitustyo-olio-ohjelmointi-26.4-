package com.example.harjoitustyo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {
    ImageView userIconImage;
    TextView lutemonName, lutemonAttack, lutemonDefense, lutemonLife, lutemonExp, lutemonLosedFights;

    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        userIconImage = itemView.findViewById(R.id.imageView);
        lutemonName = itemView.findViewById(R.id.txtName);
        lutemonAttack = itemView.findViewById(R.id.txtAttack);
        lutemonDefense = itemView.findViewById(R.id.txtDefense);
        lutemonLife = itemView.findViewById(R.id.txtLife);
        lutemonExp = itemView.findViewById(R.id.txtExperience);
        lutemonLosedFights = itemView.findViewById(R.id.txtLosedFights);
    }
}