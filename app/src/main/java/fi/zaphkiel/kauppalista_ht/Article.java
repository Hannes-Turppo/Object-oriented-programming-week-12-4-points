package fi.zaphkiel.kauppalista_ht;

import android.text.Editable;

import java.io.Serializable;

public class Article implements Serializable {
    public String textField;

    public Article() {
        textField = null;
    }

    public Article(String textField) {
        this.textField = textField;
    }
    public void setTextField(String textField) {
        this.textField = textField;
    }
}
