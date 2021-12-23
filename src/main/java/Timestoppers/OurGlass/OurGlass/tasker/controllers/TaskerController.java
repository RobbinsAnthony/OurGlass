package Timestoppers.OurGlass.OurGlass.tasker.controllers;

import Timestoppers.OurGlass.OurGlass.tasker.exceptions.TaskerNotFoundException;
import Timestoppers.OurGlass.OurGlass.tasker.models.Tasker;
import Timestoppers.OurGlass.OurGlass.tasker.services.TaskerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasker")
public class TaskerController {
    private final Logger logger = LoggerFactory.getLogger(TaskerController.class);
    private TaskerService taskerService;
    private Tasker tasker;


    @Autowired
    public TaskerController(TaskerService taskerService) {this.taskerService = taskerService;}

    @PostMapping("")
    public ResponseEntity<Tasker> createTaskerRequest(@RequestBody Tasker tasker) {
        Tasker savedTasker = taskerService.create(tasker);
        ResponseEntity response = new ResponseEntity(savedTasker, HttpStatus.CREATED);
        return response;
    }

    @GetMapping("/{id}") //should this be id or something else
    public ResponseEntity<?> getTaskerById(@PathVariable Long id){
        try {
            Tasker tasker = taskerService.getTaskerById(id); //should ID be cap
            ResponseEntity<?> response = new ResponseEntity<>(tasker, HttpStatus.OK);
            return response;
        }catch (TaskerNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable Long id, @RequestBody Tasker tasker){
        try{
            Tasker updatedTasker = taskerService.updateTasker(id, tasker);
            ResponseEntity response = new ResponseEntity(updatedTasker, HttpStatus.OK);
            return response;
        } catch (TaskerNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfile(@PathVariable Long id){
        try {
            taskerService.deleteTasker(id);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }catch (TaskerNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
}
