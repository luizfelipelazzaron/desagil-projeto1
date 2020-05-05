package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.Toast;

public class SendMessage extends AppCompatActivity {

    // Método de conveniência para mostrar uma bolha de texto.
    private void showToast(String text) {

        // Constrói uma bolha de duração curta.
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

        // Mostra essa bolha.
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        Button buttonSend = findViewById(R.id.button_send);

        String message = getIntent().getExtras().getString("message");

        showToast(message);

        buttonSend.setOnClickListener((view) -> {

            if (message.isEmpty()) {
                showToast("Mensagem inválida!");
                return;
            }

            // String phone = textPhone.getText().toString();
            String phone = "+5511988284562";

            if (!PhoneNumberUtils.isGlobalPhoneNumber(phone)) {
                showToast("Número inválido!");
                return;
            } else {
                showToast("Mensagem enviada");
            }
            showToast(message);

            SmsManager manager = SmsManager.getDefault();
            manager.sendTextMessage(phone, null, message, null, null);

        });

    }

}
