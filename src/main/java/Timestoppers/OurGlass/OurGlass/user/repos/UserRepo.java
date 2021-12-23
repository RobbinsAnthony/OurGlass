package Timestoppers.OurGlass.OurGlass.user.repos;

import Timestoppers.OurGlass.OurGlass.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long id);
}
