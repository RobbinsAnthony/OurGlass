package Timestoppers.OurGlass.OurGlass.alertnotifications.services;

import Timestoppers.OurGlass.OurGlass.alertnotifications.exceptions.AlertNotificationNotFoundException;
import Timestoppers.OurGlass.OurGlass.alertnotifications.models.AlertNotification;
import Timestoppers.OurGlass.OurGlass.alertnotifications.repos.AlertNotificationsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertNotificationServiceImpl implements AlertNotificationService{

    private static Logger logger = LoggerFactory.getLogger(AlertNotificationServiceImpl.class);

    private AlertNotificationsRepo alertNotificationRepo;

    @Autowired
    public AlertNotificationServiceImpl(AlertNotificationsRepo alertNotificationRepo) {
        this.alertNotificationRepo = alertNotificationRepo;
    }


    @Override
    public AlertNotification create(AlertNotification alertNotification){
    AlertNotification savedAlertNotification = alertNotificationRepo.save(alertNotification);
        return savedAlertNotification;
    }

    @Override
    public AlertNotification getAlertNotificationById(Long id) throws AlertNotificationNotFoundException {
        Optional<AlertNotification> alertNotificationOptional = alertNotificationRepo.findAlertNotificationById(id);
        if(alertNotificationOptional.isEmpty()) {
            logger.error("Alert notification employee number {} does not exist");
            throw new AlertNotificationNotFoundException("Alert notification not found");
        }
        return alertNotificationOptional.get();
    }

    @Override
    public List<AlertNotification> getAllAlerts() {
        return (List) alertNotificationRepo.findAll();
    }

    @Override
    public AlertNotification updateAlertNotification(Long id, AlertNotification alertNotification) throws AlertNotificationNotFoundException {
        Optional<AlertNotification> alertNotificationOptional = alertNotificationRepo.findAlertNotificationById(id);
        if(alertNotificationOptional.isEmpty()){
            throw new AlertNotificationNotFoundException("Alert notification does not exists, can not update");
        }
        AlertNotification savedAlertNotification = alertNotificationOptional.get();
        savedAlertNotification.setAlertNotificationId(alertNotification.getAlertNotificationId());

        return alertNotificationRepo.save(savedAlertNotification);
    }

    @Override
    public Boolean deleteAlertNotification(Long id) throws AlertNotificationNotFoundException {
        Optional<AlertNotification> alertNotificationOptional = alertNotificationRepo.findAlertNotificationById(id);
        if(alertNotificationOptional.isEmpty()){
            throw new AlertNotificationNotFoundException("Alert does not exist, can not delete");
        }
        AlertNotification alertNotificationToDelete = alertNotificationOptional.get();
        alertNotificationRepo.delete(alertNotificationToDelete);
        return true;
    }

}




