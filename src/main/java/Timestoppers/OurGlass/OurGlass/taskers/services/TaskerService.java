package Timestoppers.OurGlass.OurGlass.taskers.services;

import Timestoppers.OurGlass.OurGlass.taskers.Exceptions.TaskerNotFoundException;
import Timestoppers.OurGlass.OurGlass.taskers.models.Tasker;

import java.util.List;

public interface TaskerService {
    Tasker create(Tasker tasker);
    Tasker getTaskerById (Long id) throws TaskerNotFoundException;
    //List<Tasker> getAllTaskers();
    Tasker updateTasker(Long id, Tasker tasker) throws TaskerNotFoundException;
    Boolean deleteTasker(Long id) throws TaskerNotFoundException;
}
