package team.simpleVirtualWallet.beUser.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.simpleVirtualWallet.beUser.model.User;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    Optional<User> findByAccount(String account);

    Optional<User> findByMail(String mail);

    Optional<User> findByPhone(String phone);

}