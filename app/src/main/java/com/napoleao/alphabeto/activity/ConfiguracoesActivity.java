package com.napoleao.alphabeto.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.napoleao.alphabeto.R;
import com.napoleao.alphabeto.config.AppConfig;

public class ConfiguracoesActivity extends AppCompatActivity {

    private AppConfig configurator;
    private RadioGroup rgLetterType;
    private RadioButton rbCursiva;
    private RadioButton rbBastao;
    private RadioGroup rgLetterCase;
    private RadioButton rbUpper;
    private RadioButton rbLower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);

        this.configurator = AppConfig.getInstance(getApplicationContext());

        this.rgLetterType = findViewById(R.id.rgLetterType);
        this.rgLetterCase = findViewById(R.id.rgLetterCase);
        this.rbCursiva = findViewById(R.id.rdButtonCursiva);
        this.rbBastao = findViewById(R.id.rdButtonBastao);
        this.rbUpper = findViewById(R.id.rdButtonMaiusculas);
        this.rbLower = findViewById(R.id.rdButtonMinusculas);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadConfigsInView();
    }

    public void backToMainScreen(View view){
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * Muda as configurações no AppConfig de acordo com as opções selecionadas na tela de configurações
     */
    private void pushChanges(){
        String rgSelectedLetterType =((RadioButton)findViewById(this.rgLetterType.getCheckedRadioButtonId())).getText().toString();
        String rgSelectedLetterCase =((RadioButton)findViewById(this.rgLetterCase.getCheckedRadioButtonId())).getText().toString();
        this.configurator.setCurrentLetterType(rgSelectedLetterType);
        this.configurator.setCurrentLetterCase(rgSelectedLetterCase);
    }

    /**
     * Marca as opções dos RadioButton de acordo com as configurações do AppConfig
     */
    private void loadConfigsInView(){
        Log.i("Json-Config","Entrou em LoadConfigs");
        Log.i("Json-Config","CurrentLetterType: " + this.configurator.getCurrentLetterType());
        Log.i("Json-Config","CurrentLetterCase: " + this.configurator.getCurrentLetterCase());
        switch(this.configurator.getCurrentLetterType()){
            case(AppConfig.CURSIVA):
                rgLetterType.check(rbCursiva.getId());
                break;

            case(AppConfig.BASTAO):
                rgLetterType.check(rbBastao.getId());
                break;
        }

        switch(this.configurator.getCurrentLetterCase()){
            case(AppConfig.UPPER):
                rgLetterCase.check(rbUpper.getId());
                break;

            case(AppConfig.LOWER):
                rgLetterCase.check(rbLower.getId());
                break;
        }
    }

    /**
     * Salva as configurações atuais da tela de configurações e recarrega a tela.
     * @param view
     */
    public void saveChanges(View view){
        pushChanges();
        this.configurator.saveAllChange(getApplicationContext());
        this.recreate();
        Toast.makeText(this, "Configurações salvas com sucesso!", Toast.LENGTH_SHORT).show();
    }
}
