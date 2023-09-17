package com.example.s336154_mappe1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class OmspillAktivitet extends AppCompatActivity implements
        MinDialog.MittInterface {


    public void onYesClick() {
        finish();
    }

    public void onNoClick() {
        return;
    }

    public void visDialog(View v) {
        DialogFragment dialog = new MinDialog();
        dialog.show(getSupportFragmentManager(), "Tittel");
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.om_spill);
        Log.d("I om spill ", "oncreate Om Spill Aktivitet");
        Button omspill_knapp1=findViewById(R.id.omspill_knapp1);
        omspill_knapp1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                visDialog(view);
            } }); }
}