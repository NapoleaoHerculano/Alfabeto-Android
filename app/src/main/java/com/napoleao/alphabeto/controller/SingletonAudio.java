package com.napoleao.alphabeto.controller;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import java.util.Locale;

public class SingletonAudio implements TextToSpeech.OnInitListener{

    private Context myContext;
    private static SingletonAudio singleton;
    private TextToSpeech tts;

    private SingletonAudio(Context context) {
        myContext = context;
        tts = new TextToSpeech(context, this, "com.google.android.tts");
    }

    public static synchronized SingletonAudio getSingleton(Context context) {
        if(singleton == null){
            singleton = new SingletonAudio(context);
        }

        return singleton;
    }

    public static synchronized SingletonAudio getSingleton(){
        if(singleton == null){
            throw new RuntimeException("Não há instância do serviço de áudio! Alguma activity deve" +
                    " chamar o SingletonAudio inicialmente");
        }else{
            return singleton;
        }
    }

    public void ditarFoto(String palavra){
        tts.speak(palavra, tts.QUEUE_FLUSH, null);
    }

    @Override
    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS){
            tts.setLanguage(Locale.getDefault());
            Toast toast = Toast.makeText(myContext, "Serviço de áudio carregado com sucesso!", Toast.LENGTH_LONG);
            toast.show();
        }else{
            Toast toast = Toast.makeText(myContext, "Serviço de áudio indisponível. Reinicie o aplicativo!", Toast.LENGTH_LONG);
            toast.show();
        }

    }

    public void stopTts(){
        tts.stop();
        tts.shutdown();
        singleton = null;
    }
}
