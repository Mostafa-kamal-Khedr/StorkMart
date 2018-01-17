package com.example.visionstech.storkmart.Class;


import android.annotation.SuppressLint;
import android.content.Context;

import java.lang.ref.WeakReference;


public class SharedPreferencesManager {
    private static SharedPreferencesManager prefManager;
    private static SecurePreferences prefs;
    private static SecurePreferences.Editor editor;
    private WeakReference<Context> contextReference;

    @SuppressLint("CommitPrefEdits")
    private SharedPreferencesManager(Context context) {
        contextReference = new WeakReference<>(context.getApplicationContext());
      /*  if (prefs == null) {
//            prefs = new SecurePreferences(getContext(), BuildConfig.apiKey,
                    SharedPrefs.shared_pref);
        }*/

        if (editor == null) {
            editor = prefs.edit();
        }
    }


    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static SharedPreferencesManager getInstance() {
        if (prefManager == null) {
            throw new NullPointerException("Please, initialize the object in the Application class" +
                    " using SharedPreferencesManager$initialize");
        }
        return prefManager;
    }

    /**
     * Initialize.
     *
     * @param applicationContext the application context
     */
    public static void initialize(Context applicationContext) {
        if (prefManager == null) {
            prefManager = new SharedPreferencesManager(applicationContext.getApplicationContext());
        }
    }

    private Context getContext() {
        return contextReference.get();
    }

    /**
     * Contains boolean.
     *
     * @param key the key
     * @return the boolean
     */
    public boolean contains(String key) {
        return prefs.contains(key);
    }

    /**
     * Gets string.
     *
     * @param stringRes the string res
     * @param defValue  the def value
     * @return the string
     */
    public String getString(int stringRes, String defValue) {
        return getString(getContext().getString(stringRes), defValue);
    }

    /**
     * Gets string.
     *
     * @param key      the key
     * @param defValue the def value
     * @return the string
     */
    public String getString(String key, String defValue) {
        return prefs.getString(key, defValue);
    }

    /**
     * Put string.
     *
     * @param stringRes the string res
     * @param defValue  the def value
     */
    public void putString(int stringRes, String defValue) {
        putString(getContext().getString(stringRes), defValue);
    }

    /**
     * Put string.
     *
     * @param key   the key
     * @param value the value
     */
    public void putString(String key, String value) {
        editor.putString(key, value);
        apply();
    }

    /**
     * Gets int.
     *
     * @param stringRes the string res
     * @param defValue  the def value
     * @return the int
     */
    public int getInt(int stringRes, int defValue) {
        return getInt(getContext().getString(stringRes), defValue);
    }

    /**
     * Gets int.
     *
     * @param key      the key
     * @param defValue the def value
     * @return the int
     */
    public int getInt(String key, int defValue) {
        return prefs.getInt(key, defValue);
    }

    /**
     * Put int.
     *
     * @param stringRes the string res
     * @param value     the value
     */
    public void putInt(int stringRes, int value) {
        putInt(getContext().getString(stringRes), value);
    }

    /**
     * Put int.
     *
     * @param key   the key
     * @param value the value
     */
    public void putInt(String key, int value) {
        editor.putInt(key, value);
        apply();
    }

    /**
     * Gets int.
     *
     * @param stringRes the string res
     * @param defValue  the def value
     * @return the int
     */
    public float getFloat(int stringRes, float defValue) {
        return getFloat(getContext().getString(stringRes), defValue);
    }

    /**
     * Gets int.
     *
     * @param key      the key
     * @param defValue the def value
     * @return the int
     */
    public float getFloat(String key, float defValue) {
        return prefs.getFloat(key, defValue);
    }

    /**
     * Put int.
     *
     * @param stringRes the string res
     * @param value     the value
     */
    public void putFloat(int stringRes, float value) {
        putFloat(getContext().getString(stringRes), value);
    }

    /**
     * Put int.
     *
     * @param key   the key
     * @param value the value
     */
    public void putFloat(String key, float value) {
        editor.putFloat(key, value);
        apply();
    }

    /**
     * Gets boolean.
     *
     * @param stringRes the string res
     * @param defValue  the def value
     * @return the boolean
     */
    public boolean getBoolean(int stringRes, boolean defValue) {
        return getBoolean(getContext().getString(stringRes), defValue);
    }

    /**
     * Gets boolean.
     *
     * @param key      the key
     * @param defValue the def value
     * @return the boolean
     */
    public boolean getBoolean(String key, boolean defValue) {
        return prefs.getBoolean(key, defValue);
    }

    /**
     * Put boolean.
     *
     * @param stringRes the string res
     * @param defValue  the def value
     */
    public void putBoolean(int stringRes, boolean defValue) {
        putBoolean(getContext().getString(stringRes), defValue);
    }

    /**
     * Put boolean.
     *
     * @param key   the key
     * @param value the value
     */
    public void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        apply();
    }

    /**
     * Apply.
     */
    private void apply() {
        editor.commit();
    }

    /**
     * Clear.
     */
    public void clear() {
        editor.clear();
        apply();
    }
}