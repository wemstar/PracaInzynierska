package edu.agh.fis.core.user.services;

import edu.agh.fis.core.user.presistance.UserDAO;
import edu.agh.fis.entity.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by wemstar on 10.01.15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO dao;

    @Override
    public boolean validateUser(String login, String password) {
        UserEntity entity = dao.locate(login);
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            ;


            md.update(password.getBytes());

            byte byteData[] = md.digest();

            if (entity == null) return false;

            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return sb.toString().equals(entity.getPassword());
    }
}
