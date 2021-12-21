package Timestoppers.OurGlass.OurGlass.alertnotifications.repos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertNotificationRepo extends JpaRepository<AlertNotification,Integer> {
    Optional<AlertNotification> findByName(String name);

}
