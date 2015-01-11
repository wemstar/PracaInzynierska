package edu.agh.fis.core.user.presistance;

import edu.agh.fis.entity.user.UserEntity;
import edu.agh.fis.utils.presistance.AbstractDAO;

/**
 * Created by wemstar on 10.01.15.
 */
public interface UserDAO extends AbstractDAO<UserEntity> {
    UserEntity locate(String login);
}
