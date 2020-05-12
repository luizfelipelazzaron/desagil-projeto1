package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SendMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_send_message);

        Button buttonSendSpecific = findViewById(R.id.cuidadorShortcut);
        Button buttonSendGeneric = findViewById(R.id.button_send);
        Button back = findViewById(R.id.back);

        String message = getIntent().getStringExtra("arg");
        String previousNewMessage = getIntent().getStringExtra("DefinedMessage");


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

            EditText inputPhone = findViewById(R.id.text_phone);

            String phoneValue = inputPhone.getText().toString();

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
            startNewMessageActivity();
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

}
