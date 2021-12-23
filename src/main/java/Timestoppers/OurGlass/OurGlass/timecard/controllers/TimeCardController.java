package Timestoppers.OurGlass.OurGlass.timecard.controllers;

import Timestoppers.OurGlass.OurGlass.timecard.exceptions.TimeCardNotFoundException;
import Timestoppers.OurGlass.OurGlass.timecard.models.TimeCard;
import Timestoppers.OurGlass.OurGlass.timecard.services.TimeCardService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/timeCard")
public class TimeCardController {
    private final Logger logger = (Logger) LoggerFactory.getLogger(TimeCardController.class);
    private TimeCardService timeCardService;


    @Autowired
    public TimeCardController(TimeCardService timeCardService){this.timeCardService = timeCardService;}

    @PostMapping("")
    public ResponseEntity<TimeCard> createTimeCardRequest(@RequestBody TimeCard timeCard){
        TimeCard savedTimeCard = timeCardService.create(timeCard);
        ResponseEntity response = new ResponseEntity(savedTimeCard, HttpStatus.CREATED);
        return response;
    }

    @GetMapping("")
    public ResponseEntity<List<TimeCard>> getAllTimeCards(){
        List<TimeCard> timeCards = timeCardService.getAllTimeCards();
        ResponseEntity<List<TimeCard>> response = new ResponseEntity<>(timeCards, HttpStatus.OK);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTimeCardById(@PathVariable Long id){
        try {
            TimeCard timeCard = timeCardService.getTimeCardById(id);
            ResponseEntity<?> response = new ResponseEntity<>(timeCard, HttpStatus.OK);
            return response;
        }catch (TimeCardNotFoundException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @GetMapping("")
    public ResponseEntity<?> updateProfile(@PathVariable Long id, @RequestBody TimeCard timeCard ){
        try{
            TimeCard updatedTimeCard = timeCardService.updateTimeCard(id, timeCard);
            ResponseEntity response = new ResponseEntity(updatedTimeCard, HttpStatus.OK);
            return response;
        } catch (TimeCardNotFoundException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfile(@PathVariable Long id){
        try{
            timeCardService.deleteTimeCard(id);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }catch (TimeCardNotFoundException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
}
