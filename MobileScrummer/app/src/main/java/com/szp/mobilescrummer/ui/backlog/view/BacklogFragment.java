package com.szp.mobilescrummer.ui.backlog.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.szp.mobilescrummer.R;
import com.szp.mobilescrummer.ui.backlog.BacklogType;

public class BacklogFragment extends Fragment {
    public BacklogFragment(BacklogType backlogType) {
        this.backlogType = backlogType;
    }

    private final BacklogType backlogType;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_backlog, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.fragment_backlog_recycler_list_view);

        return rootView;
    }
}
