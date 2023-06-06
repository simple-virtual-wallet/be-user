package team.simpleVirtualWallet.beUser.beUserService.service;

import org.springframework.stereotype.Service;
import team.simpleVirtualWallet.beUser.beUserService.model.User;

import java.util.Optional;


public interface UserService {

    int addUser(User user);

    Optional<User> getUser(Integer id, String account, String mail, String phone);

    User verifyUser(String account, String password);

}
