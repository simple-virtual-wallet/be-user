package team.simpleVirtualWallet.beUser.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.simpleVirtualWallet.beUser.dao.UserDao;
import team.simpleVirtualWallet.beUser.model.User;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(User user)  {
        log.info("addUser: {}", user);
        return userDao.save(user).getId();
    }

    @Override
    public Optional<User> getUser(Integer id, String account, String mail, String phone){
        log.info("getUser: {} {} {} {}", id, account, mail, phone);

        if(id != null) {
            return userDao.findById(id);
        }
        if(account != null) {
            return userDao.findByAccount(account);
        }
        if(mail != null) {
            return userDao.findByMail(mail);
        }
        if(phone != null) {
            return userDao.findByPhone(phone);
        }

        return Optional.empty();
    }

}
