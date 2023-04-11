package fi.zaphkiel.kauppalista_ht;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ArticleViewAdapter extends RecyclerView.Adapter<ArticleViewHolder> {
    private Context context;
    private ArrayList<Article> articles;
    Storage storage = Storage.getInstance();
    public ArticleViewAdapter(Context context, ArrayList<Article> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArticleViewHolder(LayoutInflater.from(context).inflate(R.layout.article_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.textView.setText(articles.get(position).textField);

        holder.BtnDelete.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            Storage.getInstance().deleteArticle(articles.get(pos));
            notifyItemRemoved(pos);
            storage.saveStorage(context);
        });

        holder.BtnEdit.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            if (holder.editText.getVisibility() == View.VISIBLE) {
                Article article = Storage.getInstance().getArticle(pos);
                article.setTextField(holder.editText.getText().toString());
                holder.editText.setVisibility(View.GONE);
                holder.textView.setVisibility(View.VISIBLE);
                storage.saveStorage(context);
                notifyDataSetChanged();
            } else {
                holder.editText.setText(holder.textView.getText().toString());
                holder.editText.setVisibility(View.VISIBLE);
                holder.textView.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}
