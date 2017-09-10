package com.khgkjg12.examples.fragment1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity implements BookListFragment.OnSelectedBookChangeListener,MyDialogFragment.OnButtonClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDialogFragment theDialog = new MyDialogFragment();
        theDialog.show(getFragmentManager(),null);
    }

    @Override
    public void onSeletedBookChanged(int bookIndex) {
        BookDescFragment bookDescFragment = (BookDescFragment)getFragmentManager().findFragmentById(R.id.fragmentDescription);

        if(bookDescFragment==null||!bookDescFragment.isInLayout()){
            //isInLayout()을 통해 fragment instance 가 현재 activity 의 view hierarchy 에 포함되는지 확인.
            //backstack에 있는 다른 orientation의 layout에 포함된 fragment instance를 걸러낸다.
            Intent intent = new Intent(this, BookDescActivity.class);
            intent.putExtra("bookIndex",bookIndex);
            startActivity(intent);
        }else {
            bookDescFragment.setBook(bookIndex);
        }
    }

    @Override
    public void onButtonClick(int buttonId) {

    }
}
