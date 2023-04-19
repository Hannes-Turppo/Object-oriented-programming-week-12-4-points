package fi.zaphkiel.kauppalista_ht;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    EditText editText;
    Button BtnDelete, BtnEdit, btnSortTime, btnSortText;
    ImageView imgImportant;

    public ArticleViewHolder(@NonNull View itemView) {
        super(itemView);
        editText = itemView.findViewById(R.id.txtEditArticle);
        textView = itemView.findViewById(R.id.txtArticleInfo);
        BtnDelete = itemView.findViewById(R.id.btnDelete);
        BtnEdit = itemView.findViewById(R.id.btnEdit);
        imgImportant = itemView.findViewById(R.id.imgImportant);
    }
}
