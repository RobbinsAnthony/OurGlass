package Timestoppers.OurGlass.OurGlass.timecard.repos;

import Timestoppers.OurGlass.OurGlass.timecard.models.TimeCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TimeCardRepo extends JpaRepository<TimeCard, Long> {
    Optional<TimeCard> findTimeCardByUserIdNumber(Long id);
}
