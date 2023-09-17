package com.example.s336154_mappe1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;






public class SpillAktivitet  extends AppCompatActivity implements
        MinDialog.MittInterface {


    public int randomIndex, randomIndex2;
    public int x = 0;
    int antallRiktig = 0;
    int antallFeil = 0;

    private String[] mListValues;
    private String[] mListRegn;
    int[] indekser = new int[16];
    String[] check, innverdi;
    private TextView resultTextView;
    EditText tekst_res;
    Button buttonOK, buttonHjelp, buttonSjekk;



    public static boolean containsValue(int[] array, int targetValue) {
        for (int value : array) {
            if (value == targetValue) {
                return true;
            }
        }
        return false;
    }


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
        setContentView(R.layout.spill_aktivitet);


        Button butt0 = (Button) findViewById(R.id.button0);
        Button butt1 = (Button) findViewById(R.id.button1);
        Button butt2 = (Button) findViewById(R.id.button2);
        Button butt3 = (Button) findViewById(R.id.button3);
        Button butt4 = (Button) findViewById(R.id.button4);
        Button butt5 = (Button) findViewById(R.id.button5);
        Button butt6 = (Button) findViewById(R.id.button6);
        Button butt7 = (Button) findViewById(R.id.button7);
        Button butt8 = (Button) findViewById(R.id.button8);
        Button butt9 = (Button) findViewById(R.id.button9);

        butt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst_res.setText(mListRegn[randomIndex2] + "0");
            }
        });

        butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst_res.setText(mListRegn[randomIndex2] + "1");
            }
        });

        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst_res.setText(mListRegn[randomIndex2] + "2");
            }
        });
        butt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst_res.setText(mListRegn[randomIndex2] + "3");
            }
        });

        butt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst_res.setText(mListRegn[randomIndex2] + "4");
            }
        });

        butt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst_res.setText(mListRegn[randomIndex2] + "5");
            }
        });

        butt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst_res.setText(mListRegn[randomIndex2] + "6");
            }
        });

        butt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst_res.setText(mListRegn[randomIndex2] + "7");
            }
        });

        butt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst_res.setText(mListRegn[randomIndex2] + "8");
            }
        });

        butt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst_res.setText(mListRegn[randomIndex2] + "9");
            }
        });


        Log.d("Indekser x", String.valueOf(x));
        mListValues = getResources().getStringArray(R.array.listValues);
        resultTextView = findViewById(R.id.tekst_regnstykke);
        randomIndex = (int) (Math.random() * mListValues.length);
        resultTextView.setText(mListValues[randomIndex]);


        tekst_res = (EditText) findViewById(R.id.res_textView);
        mListRegn = getResources().getStringArray(R.array.listRegn);
        randomIndex2 = (int) (Math.random() * mListValues.length);


        if (randomIndex2 != randomIndex) {
            tekst_res.setText(mListRegn[randomIndex2]);
        } else {
            randomIndex2 = (int) (Math.random() * mListValues.length);
            tekst_res.setText(mListRegn[randomIndex2]);
        }


        indekser[x++] = randomIndex2;
        Log.d("Indekser array", String.valueOf(indekser.length));
        Log.d("Indekser x", String.valueOf(x));


        buttonHjelp = (Button) findViewById(R.id.hjelpSpill);
        buttonHjelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTextView.setText(mListValues[randomIndex2]);

            }
        });


        buttonSjekk = (Button) findViewById(R.id.buttonCheck);
        buttonSjekk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                innverdi = tekst_res.getText().toString().split("=");
                String Str_innverdi = innverdi[1].trim();
                check = mListValues[randomIndex2].split("=");
                String Str_check = check[1].trim();
                resultTextView.setText(mListValues[randomIndex2]);
                Log.d("Check", Str_check);
                Log.d("Innverdi", Str_innverdi);

                if (Str_check.equals(Str_innverdi)) {
                    tekst_res.setText("\u2713");
                    antallRiktig++;
                    Log.d("Indekser Riktig", String.valueOf(antallRiktig));
                } else {
                    tekst_res.setText("\u274C");
                    antallFeil++;
                    Log.d("Indekser feil", String.valueOf(antallFeil));
                }
            }
        });


        buttonOK = (Button) findViewById(R.id.buttonOK);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                innverdi = tekst_res.getText().toString().split("=");
                while (innverdi.length == 2) {
                    String Str_innverdi = innverdi[1].trim();
                    Log.d("Innverdi", Str_innverdi);

                    if (Str_innverdi != " ") {
                        check = mListValues[randomIndex2].split("=");
                        String Str_check = check[1].trim();
                        Log.d("Check", Str_check);
                        Log.d("Innverdi", Str_innverdi);

                        if (Str_check.equals(Str_innverdi)) {
                            antallRiktig++;
                            Log.d("Indekser Riktig", String.valueOf(antallRiktig));
                            innverdi = new String[1];
                        } else {
                            antallFeil++;
                            Log.d("Indekser feil", String.valueOf(antallFeil));
                            innverdi = new String[1];
                        }
                    }
                }
                    randomIndex2 = (int) (Math.random() * mListValues.length);
                    while (randomIndex == randomIndex2 || containsValue(indekser, randomIndex2)) {
                        randomIndex2 = (int) (Math.random() * mListValues.length);
                    }
                    tekst_res.setText(mListRegn[randomIndex2]);
                    indekser[x++] = randomIndex2;
                    Log.d("Indekser x", String.valueOf(x));
            }
        });


        Button res_spill = findViewById(R.id.buttonRes);
        res_spill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTextView.setText("\u2713  " +String.valueOf(antallRiktig));
                tekst_res.setText("\u274C " +String.valueOf(antallFeil));
            }
        });


        Button avsluttSpill = findViewById(R.id.avsluttSpill);
        avsluttSpill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (antallFeil != 0 || antallRiktig != 0) {
                    visDialog(view);
                }
                finish();
            }
        });



    }
}