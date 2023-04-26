package com.example.harjoitustyo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.harjoitustyo.fragments.FragmentBattleField;
import com.example.harjoitustyo.fragments.FragmentHome;
import com.example.harjoitustyo.fragments.FragmentTrainingArea;

public class TabPagerAdapter extends FragmentStateAdapter {
    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragmentHome();
            case 1:
                return new FragmentTrainingArea();
            case 2:
                return new FragmentBattleField();
            default:
                return new FragmentHome();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
