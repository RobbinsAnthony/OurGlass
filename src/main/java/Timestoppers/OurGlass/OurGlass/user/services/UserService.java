package Timestoppers.OurGlass.OurGlass.user.services;

import Timestoppers.OurGlass.OurGlass.user.exceptions.UserNotFoundException;
import Timestoppers.OurGlass.OurGlass.user.models.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User getUserById(Long id) throws UserNotFoundException;
    List<User> getUsers();
    User updateUserId(Long id, User user) throws UserNotFoundException;
    Boolean deleteUser(Long id) throws UserNotFoundException;
}
