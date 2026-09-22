package com.example.avaliacao1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class ConfiguracaoActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editNome;
    private RadioButton radioMasculino;
    private RadioButton radioFeminino;
    private CheckBox checkHipolipidica;
    private CheckBox checkHipoglicidica;
    private CheckBox checkSemGluten;
    private Button buttonConfirmar;
    private Button buttonCancelar;

    private SharedPreferences sharedPrefs;
    private SharedPreferences.Editor sharedPrefsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);

        editNome = findViewById(R.id.edit_nome);
        radioMasculino = findViewById(R.id.radio_masculino);
        radioFeminino = findViewById(R.id.radio_feminino);
        checkHipolipidica = findViewById(R.id.check_hipolipidica);
        checkHipoglicidica = findViewById(R.id.check_hipoglicidica);
        checkSemGluten = findViewById(R.id.check_sem_gluten);
        buttonConfirmar = findViewById(R.id.button_confirmar);
        buttonCancelar = findViewById(R.id.button_cancelar);

        buttonConfirmar.setOnClickListener(this);
        buttonCancelar.setOnClickListener(this);

        // Abre (ou cria) a tabela de preferências chamada "MinhasPreferencias"
        sharedPrefs = getSharedPreferences("MinhasPreferencias", Context.MODE_PRIVATE);

        // Lê os valores salvos. Se nunca foi salvo nada, usa os valores padrão do enunciado.
        String nome = sharedPrefs.getString("nome", "Admin");
        String sexo = sharedPrefs.getString("sexo", "M");
        boolean hipolipidica = sharedPrefs.getBoolean("hipolipidica", false);
        boolean hipoglicidica = sharedPrefs.getBoolean("hipoglicidica", false);
        boolean semGluten = sharedPrefs.getBoolean("semGluten", false);

        editNome.setText(nome);
        if (sexo.equals("M")) {
            radioMasculino.setChecked(true);
        } else {
            radioFeminino.setChecked(true);
        }
        checkHipolipidica.setChecked(hipolipidica);
        checkHipoglicidica.setChecked(hipoglicidica);
        checkSemGluten.setChecked(semGluten);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_confirmar) {
            String nome = editNome.getText().toString();
            String sexo;
            if (radioMasculino.isChecked()) {
                sexo = "M";
            } else {
                sexo = "F";
            }

            sharedPrefsEditor = sharedPrefs.edit();
            sharedPrefsEditor.putString("nome", nome);
            sharedPrefsEditor.putString("sexo", sexo);
            sharedPrefsEditor.putBoolean("hipolipidica", checkHipolipidica.isChecked());
            sharedPrefsEditor.putBoolean("hipoglicidica", checkHipoglicidica.isChecked());
            sharedPrefsEditor.putBoolean("semGluten", checkSemGluten.isChecked());
            sharedPrefsEditor.commit();

            finish(); // volta pra tela inicial
        }

        if (v.getId() == R.id.button_cancelar) {
            // Não salva nada, só volta
            finish();
        }
    }
}