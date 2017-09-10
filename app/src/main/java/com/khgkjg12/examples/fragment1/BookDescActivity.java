package com.khgkjg12.examples.fragment1;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

public class BookDescActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_desc);
        Intent intent = getIntent();
        int bookIndex = intent.getIntExtra("bookIndex",-1);

        if(bookIndex != -1){
            FragmentManager fm = getFragmentManager();
            BookDescFragment bookDescFragment = (BookDescFragment)fm.findFragmentById(R.id.fragmentDescription);
            bookDescFragment.setBook(bookIndex);
        }
    }
}
