package fi.zaphkiel.kauppalista_ht;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
        recyclerView = findViewById(R.id.rvArticleList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ArticleViewAdapter(getApplicationContext(), storage.getStorageList()));
        adapter = recyclerView.getAdapter();
    }

    public void switchToAddArticle(View view) {
        Intent intent = new Intent(this, AddArticleActivity.class);
        startActivity(intent);
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