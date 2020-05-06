package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class NewMessage extends AppCompatActivity {
    Translator translator;
    String translated;
    String morse;
    String message;
    TextView screenText;
    TextView preview;

    private static final int REQUEST_SEND_SMS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.message = "";
        this.translated = "";

        setContentView(R.layout.activity_new_message);

        this.preview = findViewById(R.id.preview);
        this.screenText = findViewById(R.id.text_message);

        Button buttonSlash = findViewById(R.id.slash);
        Button buttonSpace = findViewById(R.id.space);
        Button buttonDash = findViewById(R.id.dash);
        Button buttonDot = findViewById(R.id.dot);
        Button buttonBackspace = findViewById(R.id.backspace);
        Button send = findViewById(R.id.enviar);

        buttonSlash.setOnClickListener((view) -> {
            setMessage("/");
        });

        buttonSpace.setOnClickListener((view) -> {
            showToast(this.message);
            this.translated = this.message;
        });

        buttonDash.setOnClickListener((view) -> {
            this.setMessage("-");
        });

        buttonDot.setOnClickListener((view) -> {
            this.setMessage(".");
        });

        buttonBackspace.setOnClickListener((view) -> {
            setMessage("backspace");
        });

        send.setOnClickListener((view -> {
            // transforma a message em uma string
            startSendMessageActivity();
        }));

    }

    private void setMorse(String morse) {
        this.morse = morse;
    }

    private void setMessage(String string) {
        if (string.equals("backspace")) {
            if (this.message.length() > 1){
                this.message = this.message.substring(0, this.message.length() - 1);
            } else {
                this.message = "";
            }
        }

        else if (string.equals("/")) {
            this.translated += Character.toString(inputMorse(this.message));
            this.preview.setText(this.translated);
        }

        else {
            this.message += string;
        }

        this.screenText.setText(this.message);
    }

    private char inputMorse(String message) {
        char morseOutput = translator.morseToChar(message);
        return translator.morseToChar(message);
    }

    private void startSendMessageActivity() {
        Intent intent = new Intent(this, SendMessage.class);
        intent.putExtra("arg", morse);
        startActivity(intent);
    }

    private void showToast(String text) {

        // Constrói uma bolha de duração curta.
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

        // Mostra essa bolha.
        toast.show();
    }
}

