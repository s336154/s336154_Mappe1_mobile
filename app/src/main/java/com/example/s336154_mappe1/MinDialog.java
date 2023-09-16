package com.example.s336154_mappe1;
import static android.app.PendingIntent.getActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

public class MinDialog extends DialogFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            callback = (MittInterface) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Kallende klasse må implementere interfacet!");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return new
                AlertDialog.Builder(getActivity()).setTitle(R.string.tittel).setPositiveButton(R.string.ok,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        callback.onYesClick();
                    }
                }).setNegativeButton(R.string.ikkeok, new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        callback.onNoClick(); }
                }).create();
    }


    private MittInterface callback;

    public interface MittInterface {
        public void onYesClick();
        public void onNoClick();
    }




}