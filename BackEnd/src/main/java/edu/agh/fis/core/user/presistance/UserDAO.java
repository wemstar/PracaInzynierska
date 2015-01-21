package edu.agh.fis.core.user.presistance;

import edu.agh.fis.entity.user.UserEntity;
import edu.agh.fis.utils.presistance.AbstractDAO;

/**
 * Pobiera użytkowników  z bazy
 */
public interface UserDAO extends AbstractDAO<UserEntity> {

    /**
     * Pobiera użytkowników z bazy na podstawie loginu
     *
     * @param login login
     * @return użytkownik
     */
    UserEntity locate(String login);
}
