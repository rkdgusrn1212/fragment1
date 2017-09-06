package com.khgkjg12.examples.fragment1;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookDescFragment extends Fragment {


    private String[] mBookDescs;
    private TextView mBookDescTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewHierarchy = inflater.inflate(R.layout.fragment_book_desc, container, false);
        mBookDescs = getResources().getStringArray(R.array.book_descriptions);
        mBookDescTextView = (TextView)viewHierarchy.findViewById(R.id.textView);
        return viewHierarchy;
    }

    public void setBook(int bookIndex){
        if(bookIndex>=0&&bookIndex<mBookDescs.length) {
            mBookDescTextView.setText(mBookDescs[bookIndex]);
        }
    }

}
