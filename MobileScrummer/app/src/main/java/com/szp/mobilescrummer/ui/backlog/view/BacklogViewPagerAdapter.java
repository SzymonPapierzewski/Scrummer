package com.szp.mobilescrummer.ui.backlog.view;

import android.content.res.Configuration;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class BacklogViewPagerAdapter extends FragmentPagerAdapter {
    private Fragment[] fragments;
    private int screenOrientation;

    public BacklogViewPagerAdapter(@NonNull FragmentManager fm, int behavior, Fragment[] fragments, int screenOrientation) {
        super(fm, behavior);
        this.fragments = fragments;
        this.screenOrientation = screenOrientation;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public float getPageWidth(int position) {
        if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            return (0.5f);
        }

        return super.getPageWidth(position);
    }
}
