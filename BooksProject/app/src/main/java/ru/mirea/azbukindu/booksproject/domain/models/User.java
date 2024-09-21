package ru.mirea.azbukindu.booksproject.domain.models;

public class User {
    private int id;
    private String username;
    private String password;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public static User getUserForTest(){
        return new User(1, "test_email", "test_password");
    }

}
