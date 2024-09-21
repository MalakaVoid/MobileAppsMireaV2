package ru.mirea.azbukindu.booksproject.domain.repository;

import ru.mirea.azbukindu.booksproject.domain.models.User;

public class UsersRepository {

    public boolean signIn(String username, String password){
        return true;
    }

    public boolean signUp(String username, String password){
        return true;
    }

    public boolean logOut(){
        return true;
    }

    public User getUserinfo(){
        return User.getUserForTest();
    }

}
