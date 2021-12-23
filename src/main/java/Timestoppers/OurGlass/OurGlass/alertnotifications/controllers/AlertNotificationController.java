package Timestoppers.OurGlass.OurGlass.alertnotifications.controllers;

import Timestoppers.OurGlass.OurGlass.alertnotifications.exceptions.AlertNotificationNotFoundException;
import Timestoppers.OurGlass.OurGlass.alertnotifications.models.AlertNotification;
import Timestoppers.OurGlass.OurGlass.alertnotifications.services.AlertNotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertNotificationController {


    private final Logger logger = LoggerFactory.getLogger(AlertNotificationController.class);
    private AlertNotificationService alertNotificationService;

    @Autowired
    public AlertNotificationController(AlertNotificationService alertNotificationService){ this.alertNotificationService = alertNotificationService;}

    @PostMapping("")
    public ResponseEntity<AlertNotification> createAlertNotificationRequest(@RequestBody AlertNotification alertNotification) {
        AlertNotification savedAlertNotification = alertNotificationService.create(alertNotification);
        ResponseEntity response = new ResponseEntity(savedAlertNotification, HttpStatus.CREATED);
        return response;

    }

    @GetMapping("")
    public ResponseEntity<List<AlertNotification>> getAllAlertNotification(){
        List<AlertNotification> alertNotifications = alertNotificationService.getAllAlerts();
        ResponseEntity<List<AlertNotification>> response = new ResponseEntity<>(alertNotifications, HttpStatus.OK);
        return response;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getProfileById(@PathVariable Long id){
        try {
            AlertNotification alertNotification = alertNotificationService.getAlertNotificationById(id);
            ResponseEntity<?> response = new ResponseEntity<>(alertNotification, HttpStatus.OK);
            return response;
        } catch (AlertNotificationNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable Long id, @RequestBody AlertNotification alertNotification){
        try{
            AlertNotification updatedAlertNotification = alertNotificationService.updateAlertNotification(id, alertNotification);
            ResponseEntity response = new ResponseEntity(id,HttpStatus.OK);
            return response;
        } catch (AlertNotificationNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

  @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfile(@PathVariable Long id){
        try{
            alertNotificationService.deleteAlertNotification(id);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } catch (AlertNotificationNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
}

