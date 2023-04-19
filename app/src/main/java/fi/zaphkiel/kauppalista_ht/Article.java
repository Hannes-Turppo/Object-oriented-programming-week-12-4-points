package fi.zaphkiel.kauppalista_ht;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

public class Article implements Serializable {
    private String textField;
    private Date date;
    private boolean important;
    public Article() {
        date = new Date();
        textField = null;
        important = false;
    }
    public Article(String textField, boolean important) {
        date = new Date();
        this.textField = textField;
        this.important = important;
    }
    public String getTextField() {
        return textField;
    }

    public Date getDate() {
        return date;
    }

    public boolean isImportant() {
        return important;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }
}
