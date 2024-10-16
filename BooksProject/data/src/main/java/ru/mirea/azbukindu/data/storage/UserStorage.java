package ru.mirea.azbukindu.data.storage;

import ru.mirea.azbukindu.data.storage.models.User;

public interface UserStorage {

    public User getUser();
    public boolean saveUser(User user);

}
