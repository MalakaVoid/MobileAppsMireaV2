package ru.mirea.azbukindu.domain.repository;

import ru.mirea.azbukindu.domain.AuthCallback;

public interface UsersRepository {

    public void signIn(String email, String password, AuthCallback authCallback);

    public void signUp(String username, String email, String password, AuthCallback authCallback);
    public Boolean checkLoggedIn();

    public void logOut();

}
