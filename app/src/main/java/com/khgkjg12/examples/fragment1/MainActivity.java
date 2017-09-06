package com.khgkjg12.examples.fragment1;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends Activity implements BookListFragment.OnSelectedBookChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void OnSeletedBookChanged(int bookIndex) {
        BookDescFragment bookDescFragment = (BookDescFragment)getFragmentManager().findFragmentById(R.id.fragmentDescription);

        if(bookDescFragment!=null)
            bookDescFragment.setBook(bookIndex);
    }
}
