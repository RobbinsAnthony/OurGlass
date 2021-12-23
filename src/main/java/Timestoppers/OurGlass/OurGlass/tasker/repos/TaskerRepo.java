package Timestoppers.OurGlass.OurGlass.tasker.repos;

import Timestoppers.OurGlass.OurGlass.tasker.models.Tasker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskerRepo extends JpaRepository<Tasker, Long> {
    Optional<Tasker> findTaskById(Long id);
}