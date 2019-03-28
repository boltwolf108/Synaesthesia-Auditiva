package com.linburgtech.synthesizer_linburg;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

//---------------------------------------------------------------------------------------

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private final int WHOLE_NOTE = 1000;
    private static final String TAG = MainActivity.class.getName();

    private void delayPlaying(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Log.e("SynthesizerActivity", "Audio playback interrupted");
        }
    }

    //-------------------------------------------------------------------------------------

    private int[] scale = {R.raw.scalee,
            R.raw.scalefs,
            R.raw.scalegs,
            R.raw.scalea,
            R.raw.scaleb,
            R.raw.scalecs,
            R.raw.scaleds,
            R.raw.scalee
    };
    private int[] starplat1 = {R.raw.scalea,
            R.raw.scalea,
            R.raw.scalehighe,
            R.raw.scalehighe,
            R.raw.scalehighfs,
            R.raw.scalehighfs,
            R.raw.scalehighe,
            R.raw.scaled,
            R.raw.scaled,
            R.raw.scalecs,
            R.raw.scalecs,
            R.raw.scaleb,
            R.raw.scaleb,
            R.raw.scalea
    };
    private int[] starplat2 = {R.raw.scalehighe,
            R.raw.scalehighe,
            R.raw.scaled,
            R.raw.scaled,
            R.raw.scalecs,
            R.raw.scalecs,
            R.raw.scaleb
    };
    private int[] allSounds = {R.raw.scalea,
            R.raw.scalea,
            R.raw.scaleb,
            R.raw.scalebb,
            R.raw.scalec,
            R.raw.scalecs,
            R.raw.scaled,
            R.raw.scaleds,
            R.raw.scalee,
            R.raw.scalef,
            R.raw.scalefs,
            R.raw.scaleg,
            R.raw.scalegs,
            R.raw.scalehighe,
            R.raw.scalehighf,
            R.raw.scalehighfs,
            R.raw.scalehighg
    };

    //--------------------------------------------------------------------------------

    private Button button1;
    private Button button2;
    private Button Awaken;
    private Button Joestar;
    private Spinner notes;
    private Spinner numbers;
    private CheckBox check;
    private MediaPlayerThread mp1;

//------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        Awaken = (Button) findViewById(R.id.Awaken);
        Joestar = (Button) findViewById(R.id.Joestar);
        mp1 = new MediaPlayerThread(MainActivity.this);
        notes = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.notes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        notes.setAdapter(adapter);
        notes.setOnItemSelectedListener(this);
        numbers = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> Toast = ArrayAdapter.createFromResource(this,
                R.array.numbers, android.R.layout.simple_spinner_item);
        Toast.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numbers.setAdapter(Toast);
        numbers.setOnItemSelectedListener(this);
        check = (CheckBox) findViewById(R.id.checkBox);

        //-----------------------------------------------------------------------------

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("SynthesizerActivity", "Challenge 0 Button clicked");
                Log.i(TAG, "hi");
                for (int i : scale) {
                    mp1.playNote(i, WHOLE_NOTE);
                }
            }
        });

//-------------------------------------------------------------------------------------------

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "Button 2 Clicked");
                int i;
                for (i = numbers.getSelectedItemPosition() + 1; i > 0; i--) {
                    mp1.playNote(allSounds[notes.getSelectedItemPosition()], WHOLE_NOTE);
                }
            }
        });

//----------------------------------------------------------------------------------------

        Awaken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Awaken my masters!");
                mp1.playNote(R.raw.scalehighe, 200);
                mp1.playNote(R.raw.scalehighg, 200);
                mp1.playNote(R.raw.scalehighe, 400);
                mp1.playNote(R.raw.scalehighg, 200);
                mp1.playNote(R.raw.scalehighf, 200);
                mp1.playNote(R.raw.scalehighg, 400);
                mp1.playNote(R.raw.scalehighf, 200);
                mp1.playNote(R.raw.scalehighe, 200);
                mp1.playNote(R.raw.scalehighf, 400);
                mp1.playNote(R.raw.scaled, 200);
                mp1.playNote(R.raw.scalec, 200);
                mp1.playNote(R.raw.scaled, 500);
                mp1.playNote(R.raw.scalehighg, 700);
                mp1.playNote(R.raw.vitas, 2000);
            }
        });

//----------------------------------------------------------------------------------------

        Joestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("SynthesizerActivity", "Challenge 0 Button clicked");
                for (int i : starplat1) {
                    mp1.playNote(i, WHOLE_NOTE/2);
                }
                if (check.isChecked()) {
                    for (int i : starplat2) {
                        mp1.playNote(i, WHOLE_NOTE / 2);
                    }
                }
                for (int i : starplat1) {
                    mp1.playNote(i, WHOLE_NOTE/2);
                }
            }


        });
    }

//-------------------------------------------------------------------------------------------

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }
    @Override
    public void onNothingSelected (AdapterView <?> parent){

        }
    }
