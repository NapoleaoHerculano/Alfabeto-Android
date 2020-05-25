package com.napoleao.alphabeto.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.napoleao.alphabeto.R;

public class SobreActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnMenuInicialSobre:
                finish();
                break;
            case R.id.btnPixabay:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://pixabay.com/pt/"));
                startActivity(intent);
                break;
        }
    }
}
