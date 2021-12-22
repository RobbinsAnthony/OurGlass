package Timestoppers.OurGlass.OurGlass.taskers.controllers;

import Timestoppers.OurGlass.OurGlass.taskers.models.Tasker;
import Timestoppers.OurGlass.OurGlass.taskers.services.TaskerService;
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
    private Tasker taskers;


        @Autowired
        public TaskerController(TaskerService taskerService) {this.taskerService = taskerService;}

        @PostMapping("")
        public ResponseEntity<Tasker> createTaskerRequest(RequestBody Tasker tasker) {
            Tasker savedTasker = taskerService.create(tasker);
            ResponseEntity response = new ResponseEntity(savedTasker, HttpStatus.CREATED);
            return response;
    }
        @GetMapping("")
        public ResponseEntity<List<Tasker>> getAllTaskers(){
            List<Tasker> tasker = taskerService.getAllTaskers();
            ResponseEntity<List<Tasker>> response = new ResponseEntity<>(taskers, HttpStatus.OK);
            return response;
    }
        @GetMapping("/{id}") //should this be id or something else
        public ResponseEntity<?> getTaskerById(@PathVariable Integer id){
            try {
                Tasker tasker = taskerService.getTaskerByID(id); //should ID be cap
                ResponseEntity<?> response = new ResponseEntity<>(tasker, HttpStatus.OK);
                return response;
            }catch (TaskerNotFoundException e) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .build();
                }
            }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable Integer id, @RequestBody Tasker tasker){
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
        public ResponseEntity<?> deleteProile(@PathVariable Integer id){
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
