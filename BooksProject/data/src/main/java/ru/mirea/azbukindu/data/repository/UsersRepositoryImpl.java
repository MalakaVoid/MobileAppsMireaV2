package ru.mirea.azbukindu.data.repository;

import ru.mirea.azbukindu.data.firebase.AuthController;
import ru.mirea.azbukindu.data.storage.models.User;
import ru.mirea.azbukindu.domain.AuthCallback;
import ru.mirea.azbukindu.domain.UserResponseCallback;
import ru.mirea.azbukindu.domain.repository.UsersRepository;

public class UsersRepositoryImpl implements UsersRepository {

    private AuthController authController;

    public UsersRepositoryImpl(AuthController authController) {
        this.authController = authController;
    }

    public void signIn(String email, String password, AuthCallback authCallback){
        authController.login(email, password, new AuthCallbackAdapter(authCallback));
    }

    public void signUp(String username, String email, String password, AuthCallback authCallback){
        authController.register(username, email, password, new AuthCallbackAdapter(authCallback));
    }
    public Boolean checkLoggedIn(){
        return authController.checkLoggedIn();
    }

    public void logOut(){
        authController.leave();
    }

    @Override
    public void getUserInfo(String id, UserResponseCallback userResponseCallback) {
        authController.getUserInfo(id, userResponseCallback);
    }

    @Override
    public String getUserId() {
        return authController.getUserId();
    }


    private static class AuthCallbackAdapter implements ru.mirea.azbukindu.data.firebase.AuthCallback {

        private final AuthCallback authCallback;

        public AuthCallbackAdapter(AuthCallback authCallback) {
            this.authCallback = authCallback;
        }

        @Override
        public void onSuccess() {
            authCallback.onSuccess();
        }

        @Override
        public void onFailure() {
            authCallback.onFailure();
        }
    }

}
