package ru.mirea.azbukindu.domain.usecases;

import ru.mirea.azbukindu.domain.AuthCallback;
import ru.mirea.azbukindu.domain.repository.UsersRepository;

public class SignInUseCase {

    private UsersRepository usersRepository;

    public SignInUseCase(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void execute(String email, String password, AuthCallback authCallback){
        this.usersRepository.signIn(email, password, authCallback);
    }

}
