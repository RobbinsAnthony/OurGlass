package Timestoppers.OurGlass.OurGlass.timecard.services;

import Timestoppers.OurGlass.OurGlass.timecard.exceptions.TimeCardNotFoundException;
import Timestoppers.OurGlass.OurGlass.timecard.models.TimeCard;

import java.util.List;

public interface TimeCardService {
    TimeCard create(TimeCard timeCard);
    TimeCard getTimeCardById(Long id) throws TimeCardNotFoundException;
    List<TimeCard> getAllTimeCards();
    TimeCard updateTimeCard(Long id, TimeCard timeCard) throws TimeCardNotFoundException;
    Boolean deleteTimeCard(Long id) throws TimeCardNotFoundException;
}
