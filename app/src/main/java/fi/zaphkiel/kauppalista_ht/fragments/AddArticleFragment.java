package fi.zaphkiel.kauppalista_ht.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

import fi.zaphkiel.kauppalista_ht.Article;
import fi.zaphkiel.kauppalista_ht.R;
import fi.zaphkiel.kauppalista_ht.Storage;

public class AddArticleFragment extends Fragment {
    EditText txtArticleInfoIn;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddArticleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListItemsNowFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddArticleFragment newInstance(String param1, String param2) {
        AddArticleFragment fragment = new AddArticleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_article, container, false);
        Button btnSaveNewArticle = view.findViewById(R.id.btnAddArticle);
        txtArticleInfoIn = view.findViewById(R.id.txtArticleInfo);
        btnSaveNewArticle.setOnClickListener(view1 -> {
            saveNewArticle(view);
        });

        if (getArguments() != null) {
        }

        return view;
    }

    public void saveNewArticle(View view) {
        txtArticleInfoIn = view.findViewById(R.id.txtArticleInfo);
        CheckBox cbImportant = view.findViewById(R.id.cbImportant);
        if (cbImportant.isChecked()) {
            Storage.getInstance().addArticle(new Article(txtArticleInfoIn.getText().toString(), true));
        } else {
            Storage.getInstance().addArticle(new Article(txtArticleInfoIn.getText().toString(), false));
        }
        Storage.getInstance().saveStorage(getContext());
        txtArticleInfoIn.setText("");
    }
}
