package edu.agh.fis.core.user.services;

/**
 * Created by wemstar on 10.01.15.
 */
public interface UserService {
    boolean validateUser(String login, String password);
}
