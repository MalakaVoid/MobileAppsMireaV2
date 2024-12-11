package ru.mirea.azbukindu.domain.repository;

import ru.mirea.azbukindu.domain.AuthCallback;
import ru.mirea.azbukindu.domain.UserResponseCallback;

public interface UsersRepository {

    public void signIn(String email, String password, AuthCallback authCallback);

    public void signUp(String username, String email, String password, AuthCallback authCallback);
    public Boolean checkLoggedIn();

    public void logOut();

    public void getUserInfo(String id, UserResponseCallback userResponseCallback);
    public String getUserId();

}
