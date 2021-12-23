package Timestoppers.OurGlass.OurGlass.user.controllers;
import Timestoppers.OurGlass.OurGlass.user.exceptions.UserNotFoundException;
import Timestoppers.OurGlass.OurGlass.user.models.User;
import Timestoppers.OurGlass.OurGlass.user.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/user")
    public class UserController {

        private final Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);
        private final UserService userService;

        @Autowired
        public UserController(UserService userService){this.userService = userService;}

        @PostMapping("")
        public ResponseEntity<User> createUserRequest(@RequestBody User user){
            User savedUser = userService.create(user);
            ResponseEntity response = new ResponseEntity(savedUser, HttpStatus.CREATED);
            return response;
        }

    @GetMapping("")
    public ResponseEntity<List<User>> getUsers() {
        List<User> user = userService.getUsers();
        ResponseEntity<List<User>> response = new ResponseEntity<>(user, HttpStatus.OK);
        return response;
    }

        @GetMapping("/{id}")
        public ResponseEntity<?> getUserById(@PathVariable Long id){
            try {
                User user = userService.getUserById(id);
                ResponseEntity<?> response = new ResponseEntity<>(user, HttpStatus.OK);
                return response;
            }catch (UserNotFoundException e){
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .build();
            }
        }

    @GetMapping("")
    public ResponseEntity<?> updateProfile(@PathVariable Long id, @RequestBody User user){
        try{
            User updatedUser = userService.updateUserId(id, user);
            ResponseEntity response = new ResponseEntity(updatedUser, HttpStatus.OK);
            return response;
        } catch (UserNotFoundException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfile(@PathVariable Long id){
        try{
            userService.deleteUser(id);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }catch (UserNotFoundException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
}









