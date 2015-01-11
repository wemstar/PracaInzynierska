package edu.agh.fis.interfaces.rest.user;

import edu.agh.fis.user.UserDTO;

/**
 * Created by wemstar on 10.01.15.
 */
public interface UserAutorizeREST {

    boolean checkUser(UserDTO user);

}
