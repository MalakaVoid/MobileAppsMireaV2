package ru.mirea.azbukindu.domain.usecases;

import ru.mirea.azbukindu.domain.repository.UsersRepository;

public class LogOutUseCase {

    private UsersRepository usersRepository;

    public LogOutUseCase(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void execute(){
        this.usersRepository.logOut();
    }

}
