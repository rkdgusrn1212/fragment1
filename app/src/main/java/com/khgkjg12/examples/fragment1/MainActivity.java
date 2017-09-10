package com.khgkjg12.examples.fragment1;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
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

        if(bookDescFragment==null||!bookDescFragment.isInLayout()){
            //isInLayout()을 통해 fragment instance 가 현재 activity 의 view hierarchy 에 포함되는지 확인.
            //destroyed()된 이전 activity state의 fragment instance를 걸러낸다.
            Intent intent = new Intent(this, BookDescActivity.class);
            intent.putExtra("bookIndex",bookIndex);
            startActivity(intent);
        }else {
            bookDescFragment.setBook(bookIndex);
        }
    }
}
