package com.napoleao.alphabeto.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.napoleao.alphabeto.R;

public class SobreActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        TextView txtCreditos = findViewById(R.id.txtCreditos);

        String creditos = "As imagens usadas nos desafios foram obtidas do site: https://pt.freeimages.com";

        SpannableString ss = new SpannableString(creditos);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Toast.makeText(SobreActivity.this, "Go to", Toast.LENGTH_LONG);
            }
        };

        ss.setSpan(clickableSpan, 54, 79, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        txtCreditos.setText(creditos);
        txtCreditos.setMovementMethod(LinkMovementMethod.getInstance());
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnMenuInicialSobre:
                finish();
        }
    }
}
