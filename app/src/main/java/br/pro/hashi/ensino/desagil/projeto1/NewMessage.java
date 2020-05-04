package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class NewMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);


        Button button_new_message = findViewById(R.id.button_new_message);

        button_new_message.setOnClickListener((view -> {
            startNewMSGActivity();
        }));

    }

    private void startSMSActivity () {
        
    }

}
