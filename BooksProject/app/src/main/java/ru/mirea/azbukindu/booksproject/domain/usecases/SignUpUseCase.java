package ru.mirea.azbukindu.booksproject.domain.usecases;

import ru.mirea.azbukindu.booksproject.domain.repository.UsersRepository;

public class SignUpUseCase {

    private UsersRepository usersRepository;

    public SignUpUseCase(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public boolean execute(){
        return this.usersRepository.signUp("test_email", "test_password");
    }

}
