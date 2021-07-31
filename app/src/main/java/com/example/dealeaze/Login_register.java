 package com.example.dealeaze;

public class Login_register {

    String name;
    String email;
    String password;

    public Login_register(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Login_register() {
    }

    @Override
    public String toString() {
        return "login_register{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
