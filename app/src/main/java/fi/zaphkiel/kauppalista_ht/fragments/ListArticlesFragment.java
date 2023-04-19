package fi.zaphkiel.kauppalista_ht.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import fi.zaphkiel.kauppalista_ht.ArticleViewAdapter;
import fi.zaphkiel.kauppalista_ht.R;
import fi.zaphkiel.kauppalista_ht.Storage;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListArticlesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListArticlesFragment extends Fragment {
    private Storage storage;
    private RecyclerView rvArticleList;
    private ArticleViewAdapter adapter;
    private Button btnAlphabeticalSort, btnDateSort;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListArticlesFragment() {
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
    public static ListArticlesFragment newInstance(String param1, String param2) {
        ListArticlesFragment fragment = new ListArticlesFragment();
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
        View view = inflater.inflate(R.layout.fragment_list_articles, container, false);
        storage = Storage.getInstance();
        rvArticleList = view.findViewById(R.id.rvArticleList);
        adapter = new ArticleViewAdapter(getContext(), storage.getStorageList());
        btnAlphabeticalSort = view.findViewById(R.id.btnAlphabeticalSort);
        btnDateSort = view.findViewById(R.id.btnDateSort);

        rvArticleList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvArticleList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        btnAlphabeticalSort.setOnClickListener(view1 -> {
            Storage.getInstance().alphabethicalSort();
            adapter.notifyDataSetChanged();
        });
        btnDateSort.setOnClickListener(view1 -> {
            Storage.getInstance().timeSort();
            adapter.notifyDataSetChanged();
        });

        if (getArguments() != null) {}
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        rvArticleList.getAdapter().notifyDataSetChanged();
    }
}