package ru.mirea.azbukindu.booksproject.domain.usecases;

import ru.mirea.azbukindu.booksproject.data.repository.BooksRepository;
import ru.mirea.azbukindu.booksproject.data.repository.UsersRepository;
import ru.mirea.azbukindu.booksproject.domain.models.Book;

public class SignInUseCase {

    private UsersRepository usersRepository;

    public SignInUseCase(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public boolean execute(){
        return this.usersRepository.signIn("test_email", "test_password");
    }

}
