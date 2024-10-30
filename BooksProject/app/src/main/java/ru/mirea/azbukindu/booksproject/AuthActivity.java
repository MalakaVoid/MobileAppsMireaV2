package ru.mirea.azbukindu.booksproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import ru.mirea.azbukindu.data.firebase.AuthController;
import ru.mirea.azbukindu.data.firebase.FirebaseAuthController;
import ru.mirea.azbukindu.data.repository.UsersRepositoryImpl;
import ru.mirea.azbukindu.domain.AuthCallback;
import ru.mirea.azbukindu.domain.repository.UsersRepository;
import ru.mirea.azbukindu.domain.usecases.CheckUserLoggedInUseCase;
import ru.mirea.azbukindu.domain.usecases.SignInUseCase;
import ru.mirea.azbukindu.domain.usecases.SignUpUseCase;

public class AuthActivity extends AppCompatActivity {

    private RelativeLayout loginForm;
    private EditText loginEmailField;
    private EditText loginPasswordField;
    private Button loginButtonSubmit;
    private Button buttonRegister;

    private RelativeLayout registerForm;
    private EditText registerEmailField;
    private EditText registerPasswordField;
    private EditText registerNameField;
    private Button registerButtonSubmit;
    private Button buttonEnter;

    private CheckUserLoggedInUseCase checkUserLoggedInUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        setUpView();
        checkLoggedIn();
    }

    private void setUpView(){

        loginForm = findViewById(R.id.loginForm);
        loginEmailField = findViewById(R.id.loginEmailField);
        loginPasswordField = findViewById(R.id.loginPasswordField);
        loginButtonSubmit = findViewById(R.id.loginButtonSubmit);
        buttonEnter = findViewById(R.id.buttonEnter);

        registerForm = findViewById(R.id.registerForm);
        registerNameField = findViewById(R.id.registerNameField);
        registerEmailField = findViewById(R.id.registerEmailField);
        registerPasswordField = findViewById(R.id.registerPasswordField);
        registerButtonSubmit = findViewById(R.id.registerButtonSubmit);
        buttonRegister = findViewById(R.id.buttonRegister);

        AuthController firebaseAuthController = new FirebaseAuthController();
        UsersRepositoryImpl usersRepository = new UsersRepositoryImpl(firebaseAuthController);
        SignUpUseCase signUpUseCase = new SignUpUseCase(usersRepository);
        SignInUseCase signInUseCase = new SignInUseCase(usersRepository);
        checkUserLoggedInUseCase = new CheckUserLoggedInUseCase(usersRepository);

        changeForm(true);
        buttonEnter.setOnClickListener(view -> changeForm(true));
        buttonRegister.setOnClickListener(view -> changeForm(false));

        loginButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginEmailField.getText().toString().trim();
                String password = loginPasswordField.getText().toString().trim();
                if (password == "" || email == "" || password.length() < 4) {
                    return;
                }

                signInUseCase.execute(email, password, new AuthCallback() {
                    @Override
                    public void onSuccess() {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }

                    @Override
                    public void onFailure() {
                        Log.d("MAIN_D", "Login failure");
                    }
                });
            }
        });

        registerButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = registerEmailField.getText().toString().trim();
                String password = registerPasswordField.getText().toString().trim();
                String username = registerNameField.getText().toString().trim();

                if (username == "" || email == "" || password.length() < 4) {
                    return;
                }

                signUpUseCase.execute(email, password, username, new AuthCallback() {
                    @Override
                    public void onSuccess() {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }

                    @Override
                    public void onFailure() {
                        Log.d("MAIN_D", "Registration failure");
                    }
                });
            }
        });

    }

    private void changeForm(Boolean isLogin) {
        if (isLogin) {
            loginForm.setVisibility(View.VISIBLE);
            registerForm.setVisibility(View.INVISIBLE);
        } else {
            registerForm.setVisibility(View.VISIBLE);
            loginForm.setVisibility(View.INVISIBLE);
        }
    }

    private void checkLoggedIn(){
        if (checkUserLoggedInUseCase.execute()){
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}