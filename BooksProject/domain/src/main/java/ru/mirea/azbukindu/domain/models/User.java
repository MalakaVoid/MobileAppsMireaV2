package ru.mirea.azbukindu.domain.models;

public class User {
    private String id;
    private String email;

    public User(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public static User getUserForTest(){
        return new User("1", "test_email");
    }

    public String getEmail() {
        return email;
    }
}
