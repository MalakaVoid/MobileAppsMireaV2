package ru.mirea.azbukindu.booksproject.domain.usecases;

import ru.mirea.azbukindu.booksproject.domain.repository.UsersRepository;

public class LogOutUseCase {

    private UsersRepository usersRepository;

    public LogOutUseCase(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public boolean execute(){
        return this.usersRepository.logOut();
    }

}
