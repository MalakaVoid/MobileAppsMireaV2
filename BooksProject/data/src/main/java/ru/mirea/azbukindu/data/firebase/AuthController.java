package ru.mirea.azbukindu.data.firebase;

public interface AuthController {

    public void login(String email, String password, AuthCallback authCallback);
    public void register(String username, String email, String password, AuthCallback authCallback);
    public boolean checkLoggedIn();
    public void leave();

}
