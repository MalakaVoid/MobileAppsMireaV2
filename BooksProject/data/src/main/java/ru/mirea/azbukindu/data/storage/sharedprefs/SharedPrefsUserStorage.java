package ru.mirea.azbukindu.data.storage.sharedprefs;

import android.content.Context;
import android.content.SharedPreferences;

import ru.mirea.azbukindu.data.storage.UserStorage;
import ru.mirea.azbukindu.data.storage.models.User;

public class SharedPrefsUserStorage implements UserStorage {


    private static final String SHARED_PREFS = "data";
    private static final String USER_ID = "userId";
    private static final String USER_NAME = "username";
    private static final String USER_EMAIL = "email";
    private static final String USER_PASSWORD = "password";
    private final SharedPreferences sharedPreferences;

    public SharedPrefsUserStorage(Context context) {
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
    }

    @Override
    public User getUser() {
        int id = sharedPreferences.getInt(USER_ID, 0);
        String name = sharedPreferences.getString(USER_NAME, "");
        String email = sharedPreferences.getString(USER_EMAIL, "");
        String password = sharedPreferences.getString(USER_PASSWORD, "");
        return new User(id, name, email, password);
    }

    @Override
    public boolean saveUser(User user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(USER_ID, user.getId());
        editor.putString(USER_NAME, user.getUserName());
        editor.putString(USER_EMAIL, user.getEmail());
        editor.putString(USER_PASSWORD, user.getPassword());
        editor.apply();
        return true;
    }
}
