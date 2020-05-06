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

public class NewMessage extends AppCompatActivity {

    private static final int REQUEST_SEND_SMS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_message);

        TextView message = findViewById(R.id.text_message);
        Button buttonSlash = findViewById(R.id.slash);
        Button buttonSpace = findViewById(R.id.space);
        Button buttonDash = findViewById(R.id.dash);
        Button buttonDot = findViewById(R.id.dot);
        Button buttonBackspace = findViewById(R.id.backspace);
        Button send = findViewById(R.id.enviar);

        buttonSlash.setOnClickListener((view) -> {

            message.append("/");

        });

        buttonSpace.setOnClickListener((view) -> {

            message.append(" ");

        });

        buttonDash.setOnClickListener((view) -> {

            message.append("-");

        });

        buttonDot.setOnClickListener((view) -> {

            message.append(".");

        });

        buttonBackspace.setOnClickListener((view) -> {

            message.append("NAOOOO");

        });



        send.setOnClickListener((view -> {
            startSendMessageActivity();
        }));
    }


    private void startSendMessageActivity() {
        Intent intent = new Intent(this, SendMessage.class);

        startActivity(intent);
    }
}

