package ru.mirea.azbukindu.domain.usecases;

import ru.mirea.azbukindu.domain.repository.UsersRepository;

public class CheckUserLoggedInUseCase {

    private UsersRepository usersRepository;

    public CheckUserLoggedInUseCase(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Boolean execute(){
        return usersRepository.checkLoggedIn();
    }
}
