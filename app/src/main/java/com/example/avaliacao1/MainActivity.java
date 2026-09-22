package com.example.avaliacao1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonConfigurar;
    private Button buttonSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonConfigurar = findViewById(R.id.button_configurar);
        buttonSair = findViewById(R.id.button_sair);

        buttonConfigurar.setOnClickListener(this);
        buttonSair.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_configurar) {
            Intent i = new Intent(this, ConfiguracaoActivity.class);
            startActivity(i);
        }
        if (v.getId() == R.id.button_sair) {
            finish();
        }
    }
}