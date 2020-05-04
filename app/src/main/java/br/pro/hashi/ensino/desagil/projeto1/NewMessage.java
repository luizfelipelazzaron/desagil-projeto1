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

public class NewMessage extends AppCompatActivity {

    private static final int REQUEST_SEND_SMS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_message);

        Button enviar = findViewById(R.id.enviar);

        enviar.setOnClickListener((view -> {
            startSendMessageActivity();
        }));
    }


    private void startSendMessageActivity() {
        Intent intent = new Intent(this, SendMessage.class);

        startActivity(intent);
    }
}

