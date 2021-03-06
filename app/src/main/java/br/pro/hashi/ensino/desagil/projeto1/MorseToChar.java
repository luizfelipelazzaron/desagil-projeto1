package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;

public class MorseToChar extends AppCompatActivity {
    @SuppressWarnings("unused")
    private Translator translator;
    @SuppressWarnings("unused")
    private LinkedList<String> codes;
    private String previousClassName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morse_to_char);

        Translator translator = new Translator();
        LinkedList<String> codes = translator.getCodes();
        Button back = findViewById(R.id.backDictionary);
        previousClassName = getIntent().getStringExtra("previousClassName");
        String previousClassNameForDictionary = getIntent().getStringExtra("previousClassNameForDictionary");

        // configuração da grade (4 linhas e 6 colunas
        GridLayout gridLayout = findViewById(R.id.GridLayout2);
        gridLayout.setRowCount(4);
        gridLayout.setColumnCount(9);

        // lista para guardar strings formatadas
        LinkedList<String> list = new LinkedList<>();

        // loop para relacionar 1 char em romano com 1 string em morse
        for (int i = 0; i < codes.size(); i++) {
            // esta string desta iteração é o i-ésimo elemento da LinkedList codes que vem do dicionário
            String thisString = codes.get(i);
            // este char desta iteração do loop é o char em romano correspondente ao código morse da string acima (traduzido)
            char thisChar = translator.morseToChar(thisString);

            // traço em ASCII: 8210
            // ponto em ASCII: 8226
            // formatação de um pedaço de string como no python
            String text = String.format(" %s[%c] ", thisString.replace('-', (char) 8210), thisChar).replace('.', (char) 8226);
            // adicionar a string formatada à lista criada logo antes do loop
            list.push(text);

        }
        back.setOnClickListener((view -> {
            //Mudando para a tela anterior
            if (previousClassNameForDictionary.equals("NewMessage")) {
                startNewMessageActivity();
            } else {
                startSendMessage();
            }

        }));

        // organizar a lista em ordem alfabética
        list = reverseList(list);


        // adicionar as strings da lista nas células da tabela/grid
        for (int i = 0; i < list.size(); i++) {
            // retirar em ordem os elementos da lista ordenada
            String text = list.get(i);

            // criar a view
            TextView textView = new TextView(this);
            // adicionar determinado texto à ela
            textView.setText(text);
            // configurar a fonte
            textView.setTypeface(Typeface.MONOSPACE);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);

            // adicionar a view à grid/tabela
            gridLayout.addView(textView);

        }
    }

    private void startNewMessageActivity() {
        Intent intent = new Intent(this, NewMessage.class);
        intent.putExtra("previousClassName", previousClassName);
        startActivity(intent);
    }

    private void startSendMessage() {
        Intent intent = new Intent(this, SendMessage.class);
        intent.putExtra("previousClassName", previousClassName);
        startActivity(intent);
    }

    private LinkedList<String> reverseList(LinkedList<String> list) {

        LinkedList<String> reversed = new LinkedList<>();

        for (int i = list.size() - 1; i >= 0; i--) {

            reversed.add(list.get(i));

        }
        return reversed;
    }

}
