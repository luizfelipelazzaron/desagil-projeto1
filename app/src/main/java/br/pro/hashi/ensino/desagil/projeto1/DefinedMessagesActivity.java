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

    static String  message;
    TextView textView;

    static String getMessage(){

        return message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defined_messages);

        // EditText textMessage = findViewById(R.id.text_message);
        // EditText textPhone = findViewById(R.id.text_phone)

        Spinner spinner = findViewById(R.id.spinner_messages);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.messages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        message = spinner.getSelectedItem().toString();

        if (savedInstanceState != null) {
            message = savedInstanceState.getString("GAME_STATE_KEY");
        }

        textView = (TextView) findViewById(R.id.text_view) ;

        Button enviar = findViewById(R.id.enviar);

        enviar.setOnClickListener((view -> {
            startSendMessageActivity();
        }));

    }

    public void onSaveInstanceState(Bundle outState){
        outState.putString("GAME_STATE_KEY", message);

    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        textView.setText(savedInstanceState.getString(TEXT_VIEW_KEY));
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    private void startSendMessageActivity() {
        Intent intent = new Intent(this, SendMessage.class);
        intent.putExtra("arg", this.message);
        startActivity(intent);
    }

}
