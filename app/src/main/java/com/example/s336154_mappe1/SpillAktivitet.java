package com.example.s336154_mappe1;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SpillAktivitet extends AppCompatActivity {

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spill_aktivitet);
        resultTextView = findViewById(R.id.res_textView);
        Log.d("I Spillet ", "oncreate Spillet");

        Button avsluttSpillet = findViewById(R.id.avsluttSpill);
        Intent i=new Intent(this, MainActivity.class);

        avsluttSpillet.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                finish();  startActivity(i);
            } }); }

}


