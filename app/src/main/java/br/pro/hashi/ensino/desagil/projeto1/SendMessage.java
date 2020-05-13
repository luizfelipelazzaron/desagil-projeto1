package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Stack;

public class SendMessage extends AppCompatActivity {

    private Translator translator;
    private TextView preview;
    private String temp;
    private TextView phone;
    private Stack<String> stack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_send_message);

        Button buttonSendSpecific = findViewById(R.id.cuidadorShortcut);
        Button buttonSendGeneric = findViewById(R.id.button_send);
        Button back = findViewById(R.id.back);

        Button buttonSlash = findViewById(R.id.slash);
        Button buttonDash = findViewById(R.id.dash);
        Button buttonDot = findViewById(R.id.dot);
        Button buttonBackspace = findViewById(R.id.backspace);
        Button buttonSpace = findViewById(R.id.space);


        String message = getIntent().getStringExtra("arg");
        String previousClassName = getIntent().getStringExtra("previousClassName");

        this.phone = findViewById(R.id.text_phone);
        this.translator = new Translator();
        this.preview = findViewById((R.id.translated_phone));
        this.temp = "";
        this.stack = new Stack<>();

        buttonSlash.setOnClickListener((view) -> this.setMessage("/"));
        buttonSpace.setOnClickListener((view) -> this.setMessage(" "));
        buttonDash.setOnClickListener((view) -> {
            this.temp += "-";
            phone.append("-");
        });
        buttonDot.setOnClickListener((view) -> {
            this.temp += ".";
            phone.append(".");
        });
        buttonBackspace.setOnClickListener((view) -> {
            this.setMessage("backspace");
            String receivedMessage = phone.getText().toString();
            String erasedMessage = erase(receivedMessage);
            phone.setText(erasedMessage);
        });



        buttonSendSpecific.setOnClickListener((view) -> {

            if (message.isEmpty()) {
                showToast("Mensagem inválida!");
                return;
            }

            // String phone = textPhone.getText().toString();
            String phone = "+5511988284562";

            if (!PhoneNumberUtils.isGlobalPhoneNumber(phone)) {
                showToast("Número cadastrado inválido!");
                return;
            } else {
                showToast("Mensagem enviada para o cuidador!");
            }
            SmsManager manager = SmsManager.getDefault();
            manager.sendTextMessage(phone, null, message, null, null);

        });

        buttonSendGeneric.setOnClickListener((view) -> {


            String phoneValue = phone.getText().toString();

            if (message.isEmpty()) {
                showToast("Mensagem inválida!");
                return;
            }


            // Esta verificação do número de telefone é bem
            // rígida, pois exige até mesmo o código do país.
            if (!PhoneNumberUtils.isGlobalPhoneNumber(phoneValue)) {
                showToast("Número  inválido!");
                return;
            } else {
                showToast("Mensagem enviada para " + phoneValue + " !");
            }

            // Enviar uma mensagem de SMS. Por simplicidade,
            // não estou verificando se foi mesmo enviada,
            // mas é possível fazer uma versão que verifica.
            SmsManager manager = SmsManager.getDefault();
            manager.sendTextMessage(phoneValue, null, message, null, null);

            // Limpar o campo para nenhum engraçadinho
            // ficar apertando o botão várias vezes.
            // textPhone.setText("");
        });

        back.setOnClickListener((view -> {
            //Mudando para a tela anterior
            if (previousClassName.equals("NewMessage")){
                startNewMessageActivity();
            } else {
                startDefinedMessagesActivity();
            }

        }));

    }

    // Método de conveniência para mostrar uma bolha de texto.
    private void showToast(String text) {

        // Constrói uma bolha de duração curta.
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

        // Mostra essa bolha.
        toast.show();
    }

    private void startNewMessageActivity() {
        Intent intent = new Intent(this,NewMessage.class);
        startActivity(intent);
    }

    private void startDefinedMessagesActivity() {
        Intent intent = new Intent(this,DefinedMessagesActivity.class);
        startActivity(intent);
    }

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
                this.phone.append(" ");
                this.stack.push(this.temp);
                this.temp = "";
                break;
            case "/":
                inputMorse(this.temp);
                this.stack.push(this.temp);
                this.temp = "";
                this.preview.append(" ");
                this.phone.append("/");
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

}






