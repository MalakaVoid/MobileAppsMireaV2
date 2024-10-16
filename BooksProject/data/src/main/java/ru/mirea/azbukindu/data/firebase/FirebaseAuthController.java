package ru.mirea.azbukindu.data.firebase;

import com.google.firebase.auth.FirebaseAuth;

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
    public boolean hasUserLogged() {
        return firebaseAuth.getCurrentUser() != null;
    }

    @Override
    public void leave() {
        firebaseAuth.signOut();
    }

}
