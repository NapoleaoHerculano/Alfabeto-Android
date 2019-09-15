package com.napoleao.alphabeto.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.napoleao.alphabeto.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtCores:
            case R.id.btnCores:
                select = 0;
                invocarIntent();
                break;
            case R.id.txtObjetos:
            case R.id.btnObjetos:
                select = 1;
                invocarIntent();
                break;
            case R.id.txtAnimais:
            case R.id.btnAnimais:
                select = 2;
                invocarIntent();
                break;
            case R.id.txtFrutas:
            case R.id.btnFrutas:
                select = 3;
                invocarIntent();
                break;
            case R.id.txtPaises:
            case R.id.btnPaises:
                select = 4;
                invocarIntent();
                break;
        }
    }

    private void invocarIntent(){
        Intent it = new Intent(MainActivity.this, NiveisActivity.class);
        it.putExtra("tema", select);
        startActivity(it);
        finish();
    }
}
