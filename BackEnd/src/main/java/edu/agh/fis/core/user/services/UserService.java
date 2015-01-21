package edu.agh.fis.core.user.services;

/**
 * Waliduje użytkowników
 */
public interface UserService {

    /**
     * @param login
     * @param password
     * @return TRUE jeśli dane są poprawne
     */
    boolean validateUser(String login, String password);
}
