package Timestoppers.OurGlass.OurGlass.alertnotifications.services;

import Timestoppers.OurGlass.OurGlass.alertnotifications.repos.AlertNotificationRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertNotificationImpl implements AlertNotificationService {


    private static Logger logger = LoggerFactory.getLogger(AlertNotificationServiceImpl.class);

    private AlertNotificationRepo alertNotificationRepo;

    @Autowired
    public AlertNotificationServiceImpl(AlertNotificationRepo alertNotificationRepo) {
        this.alertNotificationRepo = alertNotificationRepo;
    }

    @Override
    public AlertNotification create(AlertNotification alertNotification);

    AlertNotification savedAlertNotification = alertNotification.save(alertNotification);
        return savedAlertNotification;
}

    @Override
    public AlertNotification getEmployeeNumber(Integer id) throws AlertNotificationNotFoundExpectation {
        Optional<AlertNotification> alertOptional = alertNotificationRepo.findById(id);
        if (alertNotification.isEmpty()) {
            logger.error("Alert notification employee number {} does not exist");
            throw new AlertNotificationNotFoundExpectation("Alert notification not found");
        }
        return AlertNotificationOptional.get();
    }

@Override
public List<AlertNotification> getAllAlerts() {
        return (List) AlertNotificationRepo.findAll();
        }

@Override
public AlertNotification updateAlertNotification(Integer id, AlertNotification alertNotification) throws AlertNotificationNotFoundException {
        Optional <AlertNotification> AlertNotificationOptional = AlertNotificationRepo.findById(id);
        if(AlertNotificationOptional.isEmpty()){
        throw new AlertNotificationNotFoundException("Alert notification does not exists, can not update");
        }
        AlertNotification savedAlertNotification = alertNotificationOptional.get();
        savedAlertNotification.setEmployeeNumbers(alertNotification.getEmloyeeNumbers());

        return AlertNotificationRepo.save(savedAlertNotification);
        }

@Override
public Boolean deleteAlertNotification(Integer Id) throws AlertNotificationNotFoundException {
        Optional <AlertNotification> alertNotificationOptional = alertNotificationRepo.findById(id);
        if(alertNoticationOptional.isEmpty()){
        throw new AlertNotificationNotFoundException("Alert does not exist, can not delete");
        }
        AlertNotification alertNotificationToDelete = alertNotificationOptional.get();
        alertNotificationRepo.delete(alertNotificationToDelete);
        return true;

    }

  }

