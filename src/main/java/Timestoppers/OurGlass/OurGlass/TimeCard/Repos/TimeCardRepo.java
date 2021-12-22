package Timestoppers.OurGlass.OurGlass.TimeCard.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TimeCardRepo extends JpaRepository<TimeCard, Integer> {
    Optional<TimeCard> findTimeCardByName(String name);
}
