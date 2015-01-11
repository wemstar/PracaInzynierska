package edu.agh.fis.interfaces.rest.user;

import edu.agh.fis.core.user.services.UserService;
import edu.agh.fis.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wemstar on 10.01.15.
 */
@RequestMapping("/user")
@RestController
public class UserAutorizeRESTImpl implements UserAutorizeREST {

    @Autowired
    private UserService service;

    @Override
    @RequestMapping(value = "/autorize", method = RequestMethod.POST)
    public boolean checkUser(@RequestBody UserDTO user) {
        return service.validateUser(user.getLogin(), user.getPassword());
    }
}
