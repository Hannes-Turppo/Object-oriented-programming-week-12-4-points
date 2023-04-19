package fi.zaphkiel.kauppalista_ht;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Storage storage;
    Context context = this;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storage = Storage.getInstance();
        storage.loadStorage(context);
        TabLayout tabLayout = findViewById(R.id.tabArea);
        ViewPager2 fragmentArea = findViewById(R.id.fragmentArea);
        TabPageAdapter tabPageAdapter = new TabPageAdapter(this);
        fragmentArea.setAdapter(tabPageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragmentArea.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        fragmentArea.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });

    }

    public void sortByTime(View view) {
        storage.timeSort();
        storage.saveStorage(context);
        adapter.notifyDataSetChanged();
    }
    public void sortByText(View view) {
        storage.alphabethicalSort();
        storage.saveStorage(context);
        adapter.notifyDataSetChanged();
    }
}