package fi.zaphkiel.kauppalista_ht;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import fi.zaphkiel.kauppalista_ht.fragments.AddArticleFragment;
import fi.zaphkiel.kauppalista_ht.fragments.ListArticlesFragment;

public class TabPageAdapter extends FragmentStateAdapter {
    public TabPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new ListArticlesFragment();
            case 1:
                return new AddArticleFragment();
            default:
                return new ListArticlesFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
