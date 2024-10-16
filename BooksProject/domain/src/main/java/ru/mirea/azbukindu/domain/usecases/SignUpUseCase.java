package ru.mirea.azbukindu.domain.usecases;

import ru.mirea.azbukindu.domain.AuthCallback;
import ru.mirea.azbukindu.domain.repository.UsersRepository;

public class SignUpUseCase {

    private UsersRepository usersRepository;

    public SignUpUseCase(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void execute(String email, String password, String username, AuthCallback authCallback){
        this.usersRepository.signUp(username, email, password, authCallback);
    }

}
