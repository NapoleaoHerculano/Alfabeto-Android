package com.napoleao.alphabeto.controller;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.napoleao.alphabeto.activity.MainActivity;

public class ComponentesAuxiliares {

    public void desligarBotoes(int[] botoes, View view){
        int i;
        for(i = 0; i < botoes.length; i++){
            Button btn = view.findViewById(botoes[i]);
            btn.setEnabled(false);
        }
    }

    public void ligarBotoes(int[] botoes, View view){
        int i;
        for(i = 0; i < botoes.length; i++){
            Button btn = view.findViewById(botoes[i]);
            btn.setEnabled(true);
        }
    }

    public void vibrar(Context context){
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        long milliseconds = 100;
        vibrator.vibrate(milliseconds);
    }

    public void exibirConfirmacaoFechar(final Activity activity) {

        AlertDialog.Builder mensagem = new AlertDialog.Builder(activity);
        mensagem.setTitle("Confirmação");
        mensagem.setIcon(null);
        mensagem.setMessage("Você voltará para a tela inicial. Deseja sair da partida?");

        mensagem.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity, "Início", Toast.LENGTH_SHORT).show();
                activity.finish();
            }
        });

        mensagem.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity, "Continuando...", Toast.LENGTH_SHORT).show();
            }
        });
        mensagem.show();
    }

    public void exibirConfirmacaoVoltar(final Activity activity) {

        AlertDialog.Builder mensagem = new AlertDialog.Builder(activity);
        mensagem.setTitle("Confirmação");
        mensagem.setIcon(null);
        mensagem.setMessage("Você voltará para a seleção de temas. Deseja sair da partida?");

        mensagem.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity, "Seleção de temas", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(activity, MainActivity.class);
                activity.startActivity(it);
                activity.finish();
            }
        });

        mensagem.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity, "Continuando...", Toast.LENGTH_SHORT).show();
            }
        });
        mensagem.show();
    }

}
