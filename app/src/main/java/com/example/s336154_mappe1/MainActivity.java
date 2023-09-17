package com.example.s336154_mappe1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements
        MinDialog.MittInterface{

    @Override
    protected void onSaveInstanceState(Bundle outstate){
        super.onSaveInstanceState(outstate);
        EditText textView = (EditText) findViewById(R.id.tekst);
        outstate.putString("antall",textView.getText().toString());
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle
                                                  savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        EditText tw=(EditText) findViewById(R.id.tekst);
        tw.setText(savedInstanceState.getString("antall"));
    }

    @Override
    public void onYesClick() {
        finish();
    }
    @Override
    public void onNoClick() {
        return;
    }
    public void visDialog(View v) {
        DialogFragment dialog = new MinDialog();
        dialog.show(getSupportFragmentManager(),"Tittel");}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button StartSpill = findViewById(R.id.StartSpill);
        Intent i = new Intent(this, SpillAktivitet.class);
        StartSpill.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(i);
            }
        });

        Button omspill_knapp=findViewById(R.id.OmSpill);
        Intent r=new Intent(this, OmspillAktivitet.class);
        omspill_knapp.setOnClickListener(new View.OnClickListener() {

            @Override public void onClick(View view) {
                startActivity(r);
            } });


        Button preferanseknapp = findViewById(R.id.preferanser);
        Intent intent = new Intent(this, SettingsActivity.class);
        preferanseknapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent); }
        });

        Button dialogknapp = findViewById(R.id.Avslutt);
        dialogknapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visDialog(view);}
        });
    }
}
