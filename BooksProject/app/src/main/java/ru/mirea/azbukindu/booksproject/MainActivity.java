package ru.mirea.azbukindu.booksproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        User currentUser = User.getUserForTest();
//
//        BooksRepository booksRepository = new BooksRepositoryImpl(
//                currentUser
//        );
//        new GetAllBooksUseCase(booksRepository).execute(); // Возвращает все книги
//
//
//        UsersRepository usersRepository = new UsersRepositoryImpl();
//        new SignUpUseCase(usersRepository).execute(); // регистрирует пользователя
//
//        CommentRepository commentRepository = new CommentRepositoryImpl(currentUser);
//        new GetCommentsUseCase(commentRepository).execute(); // Возвращает все комментарии по книге

    }
}