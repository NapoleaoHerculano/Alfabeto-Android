package com.napoleao.alphabeto.config;

import android.content.Context;
import android.util.Log;

import com.napoleao.alphabeto.json.JsonManager;

import org.json.JSONException;
import org.json.JSONObject;

public class AppConfig extends JsonManager {
    private static AppConfig instance;
    public final static String CURSIVA = "cursiva";
    public final static String BASTAO = "bastão";
    public final static String UPPER = "maiúsculas";
    public final static String LOWER = "minúsculas";
    public final static String OPCAO01 = "Opção 01";
    public final static String OPCAO02 = "Opção 02";
    public final static String OPCAO03 = "Opção 03";
    private String currentLetterType;
    private String currentLetterCase;
    private String currentSound;
    private String currentButtonConfig;
    private boolean currentButtonCase;
    private JSONObject jsonObjConfig;

    private AppConfig(Context appContext){
        this.jsonObjConfig = super.getJsonObjectOfArchive(appContext);
        try {
            this.currentLetterType = (String) this.jsonObjConfig.get("letter_type");
            this.currentLetterCase = (String) this.jsonObjConfig.get("letter_case");
            this.currentSound = (String) this.jsonObjConfig.get("hit_sound");
            this.currentButtonConfig = (String) this.jsonObjConfig.get("button_font_preferences");
            this.currentButtonCase = (boolean) this.jsonObjConfig.get("button_case_preferences");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static AppConfig getInstance(Context appContext){
        if(instance == null){
            instance = new AppConfig(appContext);
        }

        return instance;
    }

    @Override
    protected String getDiretory() {
        return "configs/";
    }

    @Override
    protected String getJsonFileName() {
        return "configs.json";
    }

    public boolean isCurrentButtonCase() {
        return currentButtonCase;
    }

    public void setCurrentButtonCase(boolean currentButtonCase) {
        this.currentButtonCase = currentButtonCase;
    }

    public String getCurrentLetterType() {
        return currentLetterType;
    }

    public void setCurrentLetterType(String currentLetterType) {
        this.currentLetterType = currentLetterType.toLowerCase();
    }

    public String getCurrentLetterCase() {
        return currentLetterCase;
    }

    public void setCurrentLetterCase(String currentLetterCase) {
        this.currentLetterCase = currentLetterCase.toLowerCase();
    }

    public String getCurrentSound() {
        return currentSound;
    }

    public void setCurrentSound(String currentSound) {
        this.currentSound = currentSound;
    }

    public String getCurrentButtonConfig() {
        return currentButtonConfig;
    }

    public void setCurrentButtonConfig(String currentButtonConfig) {
        this.currentButtonConfig = currentButtonConfig;
    }

    public void saveAllChange(Context appContext){
        JSONObject newJsonObjConfig = new JSONObject();
        try {
            newJsonObjConfig.put("letter_type", this.currentLetterType);
            newJsonObjConfig.put("letter_case", this.currentLetterCase);
            newJsonObjConfig.put("hit_sound", this.currentSound);
            newJsonObjConfig.put("button_font_preferences", this.currentButtonConfig);
            newJsonObjConfig.put("button_case_preferences", this.currentButtonCase);
            this.jsonObjConfig = newJsonObjConfig;
            super.writeJsonObject(appContext, this.jsonObjConfig);
            Log.i("Json - AppConfig", "All changes have been saved");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
