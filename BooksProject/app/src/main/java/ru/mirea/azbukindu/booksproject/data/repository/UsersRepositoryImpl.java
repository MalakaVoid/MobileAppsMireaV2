package ru.mirea.azbukindu.booksproject.data.repository;

import ru.mirea.azbukindu.booksproject.domain.models.User;
import ru.mirea.azbukindu.booksproject.domain.repository.UsersRepository;

public class UsersRepositoryImpl implements UsersRepository {

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
