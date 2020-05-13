package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.LinkedList;

public class CharToMorse extends AppCompatActivity {
    private Translator translator;
    private LinkedList<String> codes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_to_morse);

        this.translator = new Translator();
        this.codes = translator.getCodes();


        GridLayout gridLayout= findViewById(R.id.GridLayout1);
        gridLayout.setRowCount(4);
        gridLayout.setColumnCount(6);

        LinkedList<String> list = new LinkedList<>();

        for (int i = 0; i < codes.size(); i++) {
            String thisString = codes.get(i);
            char thisChar = translator.morseToChar(thisString);

            TextView textView = new TextView(this);

            // traço em ASCII: 8210
            // ponto em ASCII: 8226
            String text = String.format(" %c[%s] ", thisChar, thisString.replace('-', (char)8210) ).replace('.', (char)8226);
            list.push(text);

        }
        list.sort(String::compareToIgnoreCase);
        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i);

            TextView textView = new TextView(this);
            textView.setText(text);
            textView.setTypeface(Typeface.MONOSPACE);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);


            gridLayout.addView(textView);

        }



    }








}
