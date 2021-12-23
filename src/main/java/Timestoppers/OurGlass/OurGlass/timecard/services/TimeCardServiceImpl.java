package Timestoppers.OurGlass.OurGlass.timecard.services;

import Timestoppers.OurGlass.OurGlass.timecard.exceptions.TimeCardNotFoundException;
import Timestoppers.OurGlass.OurGlass.timecard.models.TimeCard;
import Timestoppers.OurGlass.OurGlass.timecard.repos.TimeCardRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public class TimeCardServiceImpl implements TimeCardService {

    private static Logger logger = LoggerFactory.getLogger(TimeCardServiceImpl.class);
    private TimeCardRepo timeCardRepo;

    @Autowired
    public TimeCardServiceImpl(TimeCardRepo timeCardRepo) {
        this.timeCardRepo = timeCardRepo;
    }


    @Override
    public TimeCard create(TimeCard timeCard) {
        TimeCard savedTimeCard = timeCardRepo.save(timeCard);
        return savedTimeCard;
    }

    @Override
    public TimeCard getTimeCardById(Long id) throws TimeCardNotFoundException {
        Optional<TimeCard> timeCardOptional = timeCardRepo.findTimeCardByUserIdNumber(id);
        if(timeCardOptional.isEmpty()){
            logger.error("TimeCard {} does not exsist");
        }
        return timeCardOptional.get();
    }

    @Override
    public List<TimeCard> getAllTimeCards() {
        return (List) timeCardRepo.findAll();
    }

    @Override
    public TimeCard updateTimeCard(Long id, TimeCard timeCard) throws TimeCardNotFoundException {
        Optional<TimeCard> timeCardOptional = timeCardRepo.findTimeCardByUserIdNumber(id);
        if(timeCardOptional.isEmpty()){
            throw new TimeCardNotFoundException("Time Card does not exsist");
        }
        TimeCard savedTimeCard = timeCardOptional.get();
        savedTimeCard.setId(timeCard.getId());

        return timeCardRepo.save(savedTimeCard);
    }

    @Override
    public Boolean deleteTimeCard(Long id) throws TimeCardNotFoundException {
        Optional<TimeCard> timeCardOptional = timeCardRepo.findTimeCardByUserIdNumber(id);
        if(timeCardOptional.isEmpty()){
            throw new TimeCardNotFoundException("User does not exist, can not delete");
        }
        TimeCard timeCardToDelete = timeCardOptional.get();
        timeCardRepo.delete(timeCardToDelete);
        return true;
    }
}
