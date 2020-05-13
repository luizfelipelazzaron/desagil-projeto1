package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Stack;

@SuppressWarnings("unused")
public class NewMessage extends AppCompatActivity {
    private Translator translator;
    private TextView preview;
    private String temp;
    private TextView message;
    private Stack<String> stack;
    private String previousClassName;
    // --Commented out by Inspection (5/6/2020 12:29 PM):private static final int REQUEST_SEND_SMS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);

        this.message = findViewById(R.id.text_message);
        this.translator = new Translator();
        this.preview = findViewById((R.id.preview));
        this.temp = "";
        this.stack = new Stack<>();

        Button buttonSlash = findViewById(R.id.slash);
        Button buttonDash = findViewById(R.id.dash);
        Button buttonDot = findViewById(R.id.dot);
        Button buttonBackspace = findViewById(R.id.backspace);
        Button buttonSpace = findViewById(R.id.space);
        Button back = findViewById(R.id.back);
        Button send = findViewById(R.id.enviar);
        Button buttonCharToMorse = findViewById(R.id.buttonCharToMorse);
        Button buttonMorseToChar = findViewById(R.id.buttonMorseToChar);
        previousClassName = getIntent().getStringExtra("previousClassName");

        buttonSlash.setOnClickListener((view) -> this.setMessage("/"));
        buttonSpace.setOnClickListener((view) -> this.setMessage(" "));
        buttonDash.setOnClickListener((view) -> {
            this.temp += "-";
            message.append("-");
        });
        buttonDot.setOnClickListener((view) -> {
            this.temp += ".";
            message.append(".");
        });
        buttonBackspace.setOnClickListener((view) -> {
            this.setMessage("backspace");
            String receivedMessage = message.getText().toString();
            String erasedMessage = erase(receivedMessage);
            message.setText(erasedMessage);
        });
        send.setOnClickListener((view -> {
            // transforma a message em uma string
            startSendMessageActivity();
        }));

        back.setOnClickListener((view -> {
            //Mudando para a tela anterior
            startMainActivity();
        }));

        buttonCharToMorse.setOnClickListener((view -> startChartoMorse()));

        buttonMorseToChar.setOnClickListener((view -> startMorseToChar()));

    }

// --Commented out by Inspection START (5/13/2020 1:22 PM):
//    private void startDicionarioActivity2() {
//        Intent intent = new Intent(this,MorseToChar.class);
//        startActivity(intent);
//    }
// --Commented out by Inspection STOP (5/13/2020 1:22 PM)

    private void setMessage(String string) {
        switch (string) {
            case "backspace":
                if (this.temp != null && this.temp.length() > 0) {
                    this.temp = this.temp.substring(0, this.temp.length() - 1);
                } else {
                    if (!this.stack.isEmpty()) {
                        this.temp = this.stack.pop();
                    }
                    this.backspacePreview();
                }
                break;
            case " ":
                inputMorse(this.temp);
                this.message.append(" ");
                this.stack.push(this.temp);
                this.temp = "";
                break;
            case "/":
                inputMorse(this.temp);
                this.stack.push(this.temp);
                this.temp = "";
                this.preview.append(" ");
                this.message.append("/");
                break;
            default:
                this.temp += string;
                this.preview.append(string);
                break;
        }

    }

    private void backspacePreview() {
        String previewToString = this.preview.getText().toString();
        int counter;
        if (previewToString.length() > 0) {
            if (previewToString.charAt(previewToString.length() - 1) == ' ') {
                counter = 2;
            } else {
                counter = 1;
            }
            previewToString = previewToString.substring(0, previewToString.length() - counter);
            this.preview.setText(previewToString);
        }
    }

    private String erase(String string) {
        if (string != null && string.length() > 0) {
            string = string.substring(0, string.length() - 1);
        }
        return string;
    }


    private void inputMorse(String outraMessage) {
        if (outraMessage != null) {
            char morseOutput = translator.morseToChar(outraMessage);
            if (morseOutput == '#') {
                showToast("código incorreto");
            }
            String s = String.valueOf(morseOutput);
            this.preview.append(s);
        }

    }

    private void startSendMessageActivity() {
        Intent intent = new Intent(this, SendMessage.class);
        intent.putExtra("arg", this.preview.getText().toString());
        intent.putExtra("previousClassName", this.getLocalClassName());
        startActivity(intent);
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void startMorseToChar() {
        Intent intent = new Intent(this,MorseToChar.class);
        intent.putExtra("previousClassNameForDictionary", this.getLocalClassName());
        intent.putExtra("previousClassName",previousClassName );
        startActivity(intent);
    }

    private void startChartoMorse() {
        Intent intent = new Intent(this,CharToMorse.class);
        intent.putExtra("previousClassNameForDictionary", this.getLocalClassName());
        intent.putExtra("previousClassName",previousClassName );
        startActivity(intent);
    }

    @SuppressWarnings("SameParameterValue")
    private void showToast(String text) {

        // Constrói uma bolha de duração curta.
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

        // Mostra essa bolha.
        toast.show();
    }

}