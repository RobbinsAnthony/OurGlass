package Timestoppers.OurGlass.OurGlass.alertnotifications.services;

import Timestoppers.OurGlass.OurGlass.alertnotifications.exceptions.AlertNotificationNotFoundException;
import Timestoppers.OurGlass.OurGlass.alertnotifications.models.AlertNotification;

import java.util.List;

public interface AlertNotificationService {

    AlertNotification create(AlertNotification alertNotification);
    AlertNotification getAlertNotificationById(Long id) throws AlertNotificationNotFoundException;
    List<AlertNotification> getAllAlerts();
    AlertNotification updateAlertNotification(Long id, AlertNotification alertNotification) throws AlertNotificationNotFoundException;
    Boolean deleteAlertNotification(Long id) throws AlertNotificationNotFoundException;

}
