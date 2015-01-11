package edu.agh.fis.core.user.presistance;

import edu.agh.fis.entity.user.UserEntity;
import edu.agh.fis.utils.presistance.AbstractDAOImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by wemstar on 10.01.15.
 */
@Repository
public class UserDAOImpl extends AbstractDAOImpl<UserEntity> implements UserDAO {

    @Override
    public UserEntity locate(String login) {
        return (UserEntity) sessionFactory.getCurrentSession().get(UserEntity.class, login);
    }
}
