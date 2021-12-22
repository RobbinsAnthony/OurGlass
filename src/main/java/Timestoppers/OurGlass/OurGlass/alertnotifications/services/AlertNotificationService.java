package Timestoppers.OurGlass.OurGlass.alertnotifications.services;

public interface AlertNotificationService {

    AlertNotification create(AlertNotification alertNotification);
    AlertNotification getAlertNotificationByEmployeeNumber(Integer id) throws AlertNotificationNotFoundExpectation;
    List<AlertNotification> getAllAlerts();
    AlertNotification updateAlertNotification(Integer id, AlertNotification alertNotification) throws AlertNotificationNotFoundExceptation;
    Boolean deleteAlertNotification(Integer id) throws AlertNotificationNotFoundExpection;

}
