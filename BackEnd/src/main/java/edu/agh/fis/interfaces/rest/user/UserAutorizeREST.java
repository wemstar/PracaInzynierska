package edu.agh.fis.interfaces.rest.user;

import edu.agh.fis.user.UserDTO;

/**
 * Przetwarza zapytanie REST dla użytkowników
 */
public interface UserAutorizeREST {

    boolean checkUser(UserDTO user);

}
