package com.napoleao.alphabeto.controller;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

public class SingletonAudio implements TextToSpeech.OnInitListener{

    private Context myContext;
    private static SingletonAudio singleton;
    private TextToSpeech tts;

    private SingletonAudio(Context context) {
        myContext = context;
        tts = new TextToSpeech(context, this, "com.google.android.tts");
    }

    public static SingletonAudio getSingleton(Context context) {
        if(singleton == null){
            singleton = new SingletonAudio(context);
        }

        return singleton;
    }

    public void ditarFoto(String palavra){
        tts.speak(palavra, tts.QUEUE_FLUSH, null);
    }

    @Override
    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS){
            Toast toast = Toast.makeText(myContext, "Serviço de aúdio carregado com sucesso!", Toast.LENGTH_LONG);
            toast.show();
        }else{
            Toast toast = Toast.makeText(myContext, "Serviço de aúdio indisponível. Reinicie o APP!", Toast.LENGTH_LONG);
            toast.show();
        }

    }
}
