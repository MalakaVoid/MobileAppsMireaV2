package ru.mirea.azbukindu.booksproject.domain.usecases;

import ru.mirea.azbukindu.booksproject.domain.models.User;
import ru.mirea.azbukindu.booksproject.domain.repository.UsersRepository;

public class GetUserInfoUseCase {

    private UsersRepository usersRepository;

    public GetUserInfoUseCase(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User execute(){
        return this.usersRepository.getUserinfo();
    }

}
