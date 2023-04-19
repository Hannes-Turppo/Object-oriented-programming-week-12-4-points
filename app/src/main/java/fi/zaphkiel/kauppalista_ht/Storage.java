package fi.zaphkiel.kauppalista_ht;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Storage {
    private final String SAVEDFILE = "storageListFile.data";
    private ArrayList<Article> storageList = new ArrayList<>();
    private ArrayList<Article> importantList = new ArrayList<>();

    private static Storage storage = null;
    private Storage() {
    }

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public ArrayList<Article> getImportantList() {
        return importantList;
    }

    public void addImportant(Article article) {
        importantList.add(article);
    }

    public void deleteImportant(Article article) {
        importantList.remove(article);
    }

    public ArrayList<Article> getStorageList() {
        return storageList;
    }

    public void addArticle(Article article) {
        storageList.add(article);
    }

    public Article getArticle(int id) {
        Article article = storageList.get(id);
        return article;
    }

    public void deleteArticle(Article article) {
        storageList.remove(article);
        if (article.isImportant()) {
            deleteImportant(article);
        }
    }

    public void saveStorage(Context context) {
        try {
            ObjectOutputStream storageWriter = new ObjectOutputStream(context.openFileOutput(SAVEDFILE, Context.MODE_PRIVATE));
            storageWriter.writeObject(storageList);
            System.out.println("Lista tallennettu.");
            storageWriter.close();
        } catch (IOException e) {
            System.out.println("Listan tallentaminen epäonnistui.");
            e.printStackTrace();
        }
    }

    public void loadStorage(Context context) {
        try {
            ObjectInputStream storageReader = new ObjectInputStream(context.openFileInput(SAVEDFILE));
            storageList = (ArrayList<Article>) storageReader.readObject();
            System.out.println("Tallennetut tiedot ladattu.");
            storageReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Tallennettuja tietoja ei löytynyt.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Tallennettujen tietojen lataaminen epäonnistui.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Tietomuoto oli väärä.");
            e.printStackTrace();
        }
    }

    public void alphabethicalSort() {
        Collections.sort(storageList, (article, t1) -> article.getTextField().compareTo(t1.getTextField()));
    }

    public void timeSort() {
        Collections.sort(storageList, (article, t1) -> article.getDate().compareTo(t1.getDate()));
    }
}
