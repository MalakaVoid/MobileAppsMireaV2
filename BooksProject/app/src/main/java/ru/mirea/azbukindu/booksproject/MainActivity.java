package ru.mirea.azbukindu.booksproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ru.mirea.azbukindu.booksproject.data.repository.BooksRepositoryImpl;
import ru.mirea.azbukindu.booksproject.data.repository.CommentRepositoryImpl;
import ru.mirea.azbukindu.booksproject.data.repository.UsersRepositoryImpl;
import ru.mirea.azbukindu.booksproject.domain.models.User;
import ru.mirea.azbukindu.booksproject.domain.repository.BooksRepository;
import ru.mirea.azbukindu.booksproject.domain.repository.CommentRepository;
import ru.mirea.azbukindu.booksproject.domain.repository.UsersRepository;
import ru.mirea.azbukindu.booksproject.domain.usecases.GetAllBooksUseCase;
import ru.mirea.azbukindu.booksproject.domain.usecases.GetCommentsUseCase;
import ru.mirea.azbukindu.booksproject.domain.usecases.SignUpUseCase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User currentUser = User.getUserForTest();

        BooksRepository booksRepository = new BooksRepositoryImpl(
                currentUser
        );
        new GetAllBooksUseCase(booksRepository).execute(); // Возвращает все книги


        UsersRepository usersRepository = new UsersRepositoryImpl();
        new SignUpUseCase(usersRepository).execute(); // регистрирует пользователя

        CommentRepository commentRepository = new CommentRepositoryImpl(currentUser);
        new GetCommentsUseCase(commentRepository).execute(); // Возвращает все комментарии по книге

    }
}