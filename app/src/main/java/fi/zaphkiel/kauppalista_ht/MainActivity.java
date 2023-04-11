package fi.zaphkiel.kauppalista_ht;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Storage storage;
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storage= Storage.getInstance();
        storage.loadStorage(context);
        recyclerView = findViewById(R.id.rvArticleList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ArticleViewAdapter(getApplicationContext(), storage.getStorageList()));
    }

    public void sortList(View view) {

    }

    public void switchToAddArticle(View view) {
        Intent intent = new Intent(this, AddArticleActivity.class);
        startActivity(intent);
    }

    public void switchToEditArticle(View view) {
        Intent intent = new Intent(this, EditArticleActivity.class);
        startActivity(intent);
    }

}