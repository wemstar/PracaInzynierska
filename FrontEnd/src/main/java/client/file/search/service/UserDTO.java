package client.file.search.service;

import java.io.Serializable;

/**
 * DTO dla użytkownika
 */
public class UserDTO implements Serializable {

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UsertDTO{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
