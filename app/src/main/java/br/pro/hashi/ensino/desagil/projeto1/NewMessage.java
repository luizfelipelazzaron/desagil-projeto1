package br.pro.hashi.ensino.desagil.projeto1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class NewMessage extends AppCompatActivity {
    Translator translator;
    String morse;
    TextView preview;
    String temp;
    TextView message;
    Stack<String> stack;
    private static final int REQUEST_SEND_SMS = 0;

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
        Button buttonSpace = findViewById(R.id.space);
        Button buttonDash = findViewById(R.id.dash);
        Button buttonDot = findViewById(R.id.dot);
        Button buttonBackspace = findViewById(R.id.backspace);
        Button send = findViewById(R.id.enviar);

        buttonSlash.setOnClickListener((view) -> {
            this.setMessage("/");
        });
        buttonSpace.setOnClickListener((view) -> {
            this.setMessage(" ");
        });
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
    }

    private void setMessage(String string) {
        if (string.equals("backspace")) {
            if (this.temp != null && this.temp.length() > 0) {
                this.temp = this.temp.substring(0, this.temp.length() - 1);
            } else {
                if (!this.stack.isEmpty()) {
                    this.temp = this.stack.pop();
                }
                this.backspacePreview();
            }
        } else if (string.equals(" ")) {
            inputMorse(this.temp);
            this.message.append(" ");
            this.stack.push(this.temp);
            this.temp = "";
        } else if (string.equals("/")) {
            inputMorse(this.temp);
            this.stack.push(this.temp);
            this.temp = "";
            this.preview.append(" ");
            this.message.append("/");
        } else {
            this.temp += string;
            this.preview.append(string);
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

    public String erase(String string) {
        if (string != null && string.length() > 0) {
            string = string.substring(0, string.length() - 1);
        }
        return string;
    }

    private void setMorse(String morse) {
        this.morse = morse;
    }

    private void inputMorse(String outraMessage) {
        if (outraMessage != null) {
            char morseOutput = translator.morseToChar(outraMessage);
            if (morseOutput == '#') {
                showToast("código incorreto");
            }
            String s = String.valueOf(morseOutput);
            setMorse(outraMessage);
            this.preview.append(s);
        }
    }


    private void startSendMessageActivity() {
        Intent intent = new Intent(this, SendMessage.class);
        intent.putExtra("arg", this.preview.getText().toString());
        startActivity(intent);
    }

    private void showToast(String text) {

        // Constrói uma bolha de duração curta.
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

        // Mostra essa bolha.
        toast.show();
    }
}