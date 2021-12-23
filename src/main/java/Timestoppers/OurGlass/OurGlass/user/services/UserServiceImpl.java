package Timestoppers.OurGlass.OurGlass.user.services;

import Timestoppers.OurGlass.OurGlass.user.exceptions.UserNotFoundException;
import Timestoppers.OurGlass.OurGlass.user.models.User;
import Timestoppers.OurGlass.OurGlass.user.repos.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {


    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) { this.userRepo = userRepo;}


    @Override
    public User create(User user) {
        User savedUser = userRepo.save(user);
        return savedUser;
    }

    @Override
    public User getUserById(Long id) throws UserNotFoundException {
        Optional<User> userOptional = userRepo.findUserById(id);
        if(userOptional.isEmpty()) {
            logger.error("User {} does not exist");
            throw new UserNotFoundException("User not found");
        }
        return userOptional.get();
    }

    @Override
    public List<User> getUsers() {
        return (List) userRepo.findAll();
    }

    @Override
    public User updateUserId(Long id, User user) throws UserNotFoundException {
        Optional<User> userOptional = userRepo.findUserById(id);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User does not exists, can not update");
        }
        User savedUser = userOptional.get();
        savedUser.setUserIdNumber(user.getUserIdNumber());

        return userRepo.save(savedUser);
    }

    @Override
    public Boolean deleteUser(Long id) throws UserNotFoundException {
        Optional<User> userOptional = userRepo.findUserById(id);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User does not exist, can not delete");
        }
        User userToDelete = userOptional.get();
        userRepo.delete(userToDelete);
        return true;
    }
}
