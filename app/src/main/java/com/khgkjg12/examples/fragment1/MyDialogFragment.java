package com.khgkjg12.examples.fragment1;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Hyun on 2017-09-11.
 */

public class MyDialogFragment extends DialogFragment implements View.OnClickListener{

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setStyle(DialogFragment.STYLE_NORMAL,0);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View theView = inflater.inflate(R.layout.fragment_my_dialog,container,false);
        View yesButton = theView.findViewById(R.id.btnYes);
        yesButton.setOnClickListener(this);
        yesButton.requestFocus();

        View noButton = theView.findViewById(R.id.btnNo);
        noButton.setOnClickListener(this);

        Dialog dialog = getDialog();
        dialog.setTitle(getString(R.string.myDialogFragmentTitle));
        dialog.setCanceledOnTouchOutside(false);

        return theView;
    }

    public interface OnButtonClickListener{
        void onButtonClick(int buttonId);
    }

    @Override
    public void onClick(View view) {
        int buttonId = view.getId();
        OnButtonClickListener onButtonClickListener = (OnButtonClickListener)getActivity();
        onButtonClickListener.onButtonClick(buttonId);

        dismiss();
    }
}
