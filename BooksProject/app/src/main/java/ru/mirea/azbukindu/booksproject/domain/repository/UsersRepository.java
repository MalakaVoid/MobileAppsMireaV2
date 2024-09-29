package ru.mirea.azbukindu.booksproject.domain.repository;

import ru.mirea.azbukindu.booksproject.domain.models.User;

public interface UsersRepository {

    public boolean signIn(String username, String password);

    public boolean signUp(String username, String password);

    public boolean logOut();

    public User getUserinfo();

}
