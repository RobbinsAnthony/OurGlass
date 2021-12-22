package Timestoppers.OurGlass.OurGlass.taskers.services;

import Timestoppers.OurGlass.OurGlass.taskers.models.Tasker;

import java.util.List;

public interface TaskerService {
    Tasker create(Tasker tasker);
    Tasker getTaskerByprojectName /* by project name or id??*/ (String projectName) throws TaskerNotFoundException;
    List<Tasker> getALLTaskers();
    Widget updateWidget(String projectName, Tasker tasker) throws TaskerNotFoundException;
    List<Tasker> getAllTaskers();
    Tasker updatePerson(String projectName, Tasker tasker) throws TaskerNotFoundException;
    Boolean deleteTasker(String projectName) throws TaskerNotFoundException;
}
