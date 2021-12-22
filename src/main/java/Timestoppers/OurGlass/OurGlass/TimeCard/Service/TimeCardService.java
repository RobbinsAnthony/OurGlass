package Timestoppers.OurGlass.OurGlass.TimeCard.Service;

import java.util.List;

public interface TimeCardService {
    TimeCard create(TimeCard timeCard);
    TimeCard getTimeCardById(Integer id) throws TimeCardNotFoundException;
    List<TimeCard> getAllTimeCard();
    TimeCard updateTimeCard(Integer id, TimeCard timeCard) throws TimeCardNotFoundException;
    Boolean deleteWidget(Integer id) throws TimeCardNotFoundException;
}
