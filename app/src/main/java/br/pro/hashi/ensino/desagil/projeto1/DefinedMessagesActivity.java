package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DefinedMessagesActivity<Static> extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defined_messages);

        Spinner spinner = findViewById(R.id.spinner_messages);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.messages, R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Button send = findViewById(R.id.enviar);

        send.setOnClickListener((view -> startSendMessageActivity()));

    }


    private void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        setMessage(text);
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        setMessage(text);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    private void startSendMessageActivity() {
        Intent intent = new Intent(this, SendMessage.class);
        intent.putExtra("arg", message);
        startActivity(intent);
    }

}
