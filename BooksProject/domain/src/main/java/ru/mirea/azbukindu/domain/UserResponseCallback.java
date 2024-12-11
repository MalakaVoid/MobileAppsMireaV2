package ru.mirea.azbukindu.domain;

import ru.mirea.azbukindu.domain.models.User;

public interface UserResponseCallback {

    void onSuccess(User user);
    void onError();

}
