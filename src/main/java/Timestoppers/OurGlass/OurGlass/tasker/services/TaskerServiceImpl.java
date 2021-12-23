package Timestoppers.OurGlass.OurGlass.tasker.services;

import Timestoppers.OurGlass.OurGlass.tasker.exceptions.TaskerNotFoundException;
import Timestoppers.OurGlass.OurGlass.tasker.models.Tasker;
import Timestoppers.OurGlass.OurGlass.tasker.repos.TaskerRepo;
import Timestoppers.OurGlass.OurGlass.tasker.services.TaskerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskerServiceImpl implements TaskerService {

    private static Logger logger = LoggerFactory.getLogger(TaskerServiceImpl.class);
    private TaskerRepo taskerRepo;

    @Autowired
    public TaskerServiceImpl(TaskerRepo taskerRepo) {
        this.taskerRepo = taskerRepo;
    }


    @Override
    public Tasker create(Tasker tasker) {
        Tasker savedTasker = taskerRepo.save(tasker);
        return savedTasker;
    }

    @Override
    public Tasker getTaskerById(Long id) throws TaskerNotFoundException {
        Optional<Tasker> taskerOptional = taskerRepo.findTaskById(id);
        if(taskerOptional.isEmpty()) {
            logger.error("Task id {} does not exist");
            throw new TaskerNotFoundException("Task not found");
        }
        return taskerOptional.get();
    }

    @Override
    public List<Tasker> getAllTaskers() {
        return (List) taskerRepo.findAll();
    }

    @Override
    public Tasker updateTasker(Long id, Tasker tasker) throws TaskerNotFoundException {
            Optional<Tasker> taskerOptional = taskerRepo.findTaskById(id);
            if(taskerOptional.isEmpty()){
                throw new TaskerNotFoundException("Tasker does not exist, can not update");
            }
            Tasker savedTasker = taskerOptional.get();
            savedTasker.setId(tasker.getId());
            savedTasker.setTaskName(tasker.getTaskName());

            return taskerRepo.save(savedTasker);
    }

    @Override
    public Boolean deleteTasker(Long id) throws TaskerNotFoundException {
        Optional<Tasker> taskerOptional = taskerRepo.findTaskById(id);
        if(taskerOptional.isEmpty()){
            throw new TaskerNotFoundException("Tasker does not exist, can not delete");
        }
        Tasker taskerDelete = taskerOptional.get();
        taskerRepo.delete(taskerDelete);
        return true;
    }
}