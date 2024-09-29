package ru.mirea.azbukindu.booksproject.domain.usecases;

import ru.mirea.azbukindu.booksproject.domain.repository.UsersRepository;

public class SignInUseCase {

    private UsersRepository usersRepository;

    public SignInUseCase(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public boolean execute(){
        return this.usersRepository.signIn("test_email", "test_password");
    }

}
