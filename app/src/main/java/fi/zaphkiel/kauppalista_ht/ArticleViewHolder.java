package fi.zaphkiel.kauppalista_ht;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    Button iBtnDelete, iBtnEdit;

    public ArticleViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.txtArticleInfo);
        iBtnDelete = itemView.findViewById(R.id.btnDelete);
        iBtnEdit = itemView.findViewById(R.id.btnEdit);
    }
}
