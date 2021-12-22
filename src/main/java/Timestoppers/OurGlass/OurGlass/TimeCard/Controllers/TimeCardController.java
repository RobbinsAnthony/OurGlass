package Timestoppers.OurGlass.OurGlass.TimeCard.Controllers;

import Timestoppers.OurGlass.OurGlass.TimeCard.Service.TimeCardImpl;
import Timestoppers.OurGlass.OurGlass.TimeCard.Service.TimeCardService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/TimeCard")
public class TimeCardController {
    private final Logger logger = (Logger) LoggerFactory.getLogger(TimeCardController.class);
    private TimeCardController timeCardController;

    @Autowired
    public TimeCardController(TimeCardService timeCardService){this.timeCardController = (TimeCardController) timeCardService;}

    @PostMapping("")
    public ResponseEntity<TimeCard> createTimeCardRequest(@RequestBody TimeCard timeCard){
        TimeCard savedTimeCard = TimeCardService.create(timeCard);
        ResponseEntity response = new ResponseEntity(savedTimeCard, HttpStatus.CREATED);
        return response;
    }

    @GetMapping("")
    public ResponseEntity<List<TimeCard>> getAllTimeCards(){
        List<TimeCard> timeCards = TimeCardService.getAllTimeCards();
        ResponseEntity<List<TimeCard>> response = new ResponseEntity<>(timeCards, HttpStatus.OK);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProfileById(PathVariable Integer id){
        try {
            TimeCard timeCard = TimeCardService.getTimeCardById(id);
            ResponseEntity<?> response = new ResponseEntity<>(TimeCard, HttpStatus.OK);
            return response;
        }catch (TimeCardNotFoundException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @GetMapping("")
    public ResponseEntity<?> updateProfile(@PathVariable Integer id, @RequestBody TimeCard timeCard ){
        try{
            TimeCard updatedTimeCard = TimeCardService.updateTimeCard(id, timeCard);
            ResponseEntity response = new ResponseEntity(updatedTimeCard, HttpStatus.OK);
            return response;
        } catch (TimeCardNotFoundException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfile(@PathVariable Integer id){
        try{
            TimeCardService.deleteTimeCard(id);
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
