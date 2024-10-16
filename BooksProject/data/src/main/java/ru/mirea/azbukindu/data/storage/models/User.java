package ru.mirea.azbukindu.data.storage.models;

public class User {

    private int id;
    private String username;
    private String email;
    private String password;

    public int getId() {
        return id;
    }

    public String getUserName() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User(int id, String userName, String email, String password) {
        this.id = id;
        this.username = userName;
        this.email = email;
        this.password = password;
    }

    public static User getUserForTest(){
        return new User(1, "test_email", "test_password", "test");
    }

}
