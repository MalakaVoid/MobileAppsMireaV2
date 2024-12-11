package ru.mirea.azbukindu.data.firebase;

import ru.mirea.azbukindu.domain.UserResponseCallback;

public interface AuthController {

    public void login(String email, String password, AuthCallback authCallback);
    public void register(String username, String email, String password, AuthCallback authCallback);
    public boolean checkLoggedIn();
    public void leave();

    public void getUserInfo(String id, UserResponseCallback userResponseCallback);
    public String getUserId();

}
