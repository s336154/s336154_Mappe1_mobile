package com.example.s336154_mappe1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class OmspillAktivitet extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.om_spill);

        Log.d("I om spill ", "oncreate Om Spill Aktivitet");
        Button omspill_knapp1=findViewById(R.id.omspill_knapp1);
        omspill_knapp1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                finish();
            } }); }
}