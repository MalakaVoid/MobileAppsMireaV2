package ru.mirea.azbukindu.booksproject.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.mirea.azbukindu.booksproject.R;
import ru.mirea.azbukindu.data.firebase.AuthController;
import ru.mirea.azbukindu.data.firebase.FirebaseAuthController;
import ru.mirea.azbukindu.data.repository.UsersRepositoryImpl;
import ru.mirea.azbukindu.domain.UserResponseCallback;
import ru.mirea.azbukindu.domain.models.User;
import ru.mirea.azbukindu.domain.usecases.GetUserIdUseCase;
import ru.mirea.azbukindu.domain.usecases.GetUserInfoUseCase;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    private GetUserInfoUseCase getUserInfoUseCase;
    private GetUserIdUseCase getUserIdUseCase;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AuthController authController = new FirebaseAuthController();
        UsersRepositoryImpl usersRepository = new UsersRepositoryImpl(authController);
        getUserInfoUseCase = new GetUserInfoUseCase(usersRepository);
        getUserIdUseCase = new GetUserIdUseCase(usersRepository);

        TextView emailText = view.findViewById(R.id.emailText);
        getUserInfoUseCase.execute(getUserIdUseCase.execute(), new UserResponseCallback() {
            @Override
            public void onSuccess(User user) {
                emailText.setText(user.getEmail());
            }

            @Override
            public void onError() {
                emailText.setText("Error");
            }
        });
    }
}