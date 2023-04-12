package fi.zaphkiel.kauppalista_ht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddArticleActivity extends AppCompatActivity {
    Article article;
    Storage storage;
    EditText newArticleInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_article);

        storage = Storage.getInstance();
        newArticleInfo = findViewById(R.id.txtInArticleInfo);
    }

    public void switchToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void saveNewArticle(View view) {
        article = new Article();
        article.setTextField(String.valueOf(newArticleInfo.getText()));
        storage.addArticle(article);
        storage.saveStorage(this);
        switchToMain(view);
    }
}