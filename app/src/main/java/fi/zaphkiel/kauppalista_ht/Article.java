package fi.zaphkiel.kauppalista_ht;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

public class Article implements Serializable {
    private String textField;
    private Date date;
    public Article() {
        date = new Date();
        textField = null;
    }
    public Article(String textField) {
        date = new Date();
        this.textField = textField;
    }
    public String getTextField() {
        return textField;
    }

    public Date getDate() {
        return date;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }
}
