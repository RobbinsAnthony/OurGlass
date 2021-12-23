package Timestoppers.OurGlass.OurGlass.alertnotifications.repos;

import Timestoppers.OurGlass.OurGlass.alertnotifications.models.AlertNotification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlertNotificationsRepo extends JpaRepository<AlertNotification, Long> {
    Optional<AlertNotification> findAlertNotificationById(Long id);

}
