package ru.mirea.azbukindu.data.firebase;

import com.google.firebase.auth.FirebaseAuth;

import ru.mirea.azbukindu.domain.UserResponseCallback;
import ru.mirea.azbukindu.domain.models.User;

public class FirebaseAuthController implements AuthController{

    private final FirebaseAuth firebaseAuth;

    public FirebaseAuthController() {
        this.firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void login(String email, String password, AuthCallback authCallback) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    authCallback.onSuccess();
                })
                .addOnFailureListener(e -> {
                    authCallback.onFailure();
                });
    }

    @Override
    public void register(String username, String email, String password, AuthCallback authCallback) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    authCallback.onSuccess();
                })
                .addOnFailureListener(e -> {
                    authCallback.onFailure();
                });
    }

    @Override
    public boolean checkLoggedIn() {
        return firebaseAuth.getCurrentUser() != null;
    }

    @Override
    public void leave() {
        firebaseAuth.signOut();
    }

    @Override
    public void getUserInfo(String id, UserResponseCallback userResponseCallback) {
        if (firebaseAuth.getCurrentUser() != null) {
            userResponseCallback.onSuccess(new User(id, firebaseAuth.getCurrentUser().getEmail()));
        } else {
            userResponseCallback.onError();
        }
    }

    @Override
    public String getUserId() {
        return firebaseAuth.getCurrentUser().getUid();
    }
}
