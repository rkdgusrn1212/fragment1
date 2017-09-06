package com.khgkjg12.examples.fragment1;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookListFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewHierarchy = inflater.inflate(R.layout.fragment_book_list, container, false);
        RadioGroup radioGroup = viewHierarchy.findViewById(R.id.bookSelectGroup);
        radioGroup.setOnCheckedChangeListener(this);
        return viewHierarchy;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        int bookIndex = bookIdToBookIndex(i);
        ((OnSelectedBookChangeListener)getActivity()).OnSeletedBookChanged(bookIndex);
    }

    public interface OnSelectedBookChangeListener{
        void OnSeletedBookChanged(int bookIndex);
    }

    private int bookIdToBookIndex(int id){
        int bookIndex = -1;
        switch(id){
            case R.id.android4NewBook:
                bookIndex=0;
                break;
            case R.id.dynamicUiBook:
                bookIndex = 1;
                break;
        }
        return bookIndex;
    }

}
