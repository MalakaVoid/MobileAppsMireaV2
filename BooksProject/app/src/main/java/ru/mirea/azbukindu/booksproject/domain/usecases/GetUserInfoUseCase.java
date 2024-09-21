package ru.mirea.azbukindu.booksproject.domain.usecases;

import ru.mirea.azbukindu.booksproject.data.repository.UsersRepository;
import ru.mirea.azbukindu.booksproject.domain.models.User;

public class GetUserInfoUseCase {

    private UsersRepository usersRepository;

    public GetUserInfoUseCase(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User execute(){
        return this.usersRepository.getUserinfo();
    }

}
