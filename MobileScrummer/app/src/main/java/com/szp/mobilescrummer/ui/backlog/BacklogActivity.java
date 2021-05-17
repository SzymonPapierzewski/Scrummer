package com.szp.mobilescrummer.ui.backlog;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.szp.mobilescrummer.R;
import com.szp.mobilescrummer.ui.backlog.view.BacklogFragment;
import com.szp.mobilescrummer.ui.backlog.view.BacklogViewPagerAdapter;

public class BacklogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backlog);

        initViewPager();
    }

    private void initViewPager() {
        ViewPager viewPager = findViewById(R.id.activity_backlog_view_pager);
        BacklogViewPagerAdapter viewPagerAdapter = new BacklogViewPagerAdapter(
                getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
                new Fragment[]{new BacklogFragment(BacklogType.SPRINT), new BacklogFragment(BacklogType.PERSONAL)},
                BacklogActivity.this.getResources().getConfiguration().orientation);
        viewPager.setAdapter(viewPagerAdapter);
    }
}
