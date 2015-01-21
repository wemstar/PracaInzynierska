package edu.agh.fis.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Użytkownik
 */
@Entity
@Table(name = "USER")
public class UserEntity {


    @Id
    @Column(name = "USER_LOGIN")
    private String login;

    @Column(name = "USER_PASSWORD")
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
        return "UserEntity{" +
                ", login='" + login + '\'' +
                ", password=" + password +
                '}';
    }
}
