package com.khgkjg12.examples.fragment1;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Hyun on 2017-09-10.
 */

public class BookListFragment2 extends ListFragment {
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        String[] bookTitles = getResources().getStringArray(R.array.book_list);
        ArrayAdapter<String> bookTitlesAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,bookTitles);

        setListAdapter(bookTitlesAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        BookListFragment.OnSelectedBookChangeListener listener = (BookListFragment.OnSelectedBookChangeListener) getActivity();
        listener.onSeletedBookChanged(position);
    }
}
