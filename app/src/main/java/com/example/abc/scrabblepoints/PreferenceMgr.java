package com.example.abc.scrabblepoints;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by abc on 06/11/2017.
 */

public class PreferenceMgr {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context mcontext;

    int pMode = 0;
    private static final String prefName = "ScrabblePoints-Welcome";
    private static final String firstTimeLaunch = "FirstTimeLaunch";

    public PreferenceMgr(Context context) {
        this.mcontext = context;
        sharedPreferences = mcontext.getSharedPreferences(prefName, pMode);
        editor = sharedPreferences.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(firstTimeLaunch, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return sharedPreferences.getBoolean(firstTimeLaunch, true);
    }

}

