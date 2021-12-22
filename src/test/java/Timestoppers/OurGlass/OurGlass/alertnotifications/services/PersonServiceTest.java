package Timestoppers.OurGlass.OurGlass.alertnotifications.services;

import Timestoppers.OurGlass.OurGlass.alertnotifications.repos.AlertNotificationRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AlertNotificationServiceTest {

    @MockBean
    private AlertNotificationRepo mockAlertRepo;

    @Autowired
    private AlertNotificationService alertNotificationService;

    private AlertNotification inputAlertNotification;
    private AlertNotification mockResponseAlertNotication1;
    private AlertNotification mockResponseAlertNotication2;

    @BeforeEach
    public void setUp() {
        List<EmployeeNumber> number = new ArrayList<>();
        number.add(new EmployeeNumber("Number 1"));
        number.add(new EmployeeNumber("Number 2"));
        inputAlertNotification = new AlertNotification("id", number);

        mockResponseAlertNotication1 = new AlertNotification("id", number);
        mockResponseAlertNotication1.setId(12211);

        mockResponseAlertNotification2 = new AlertNotification("id", number);
        mockResponseAlertNotification2.setId(9982);
    }

    @Test
    @DisplayName("AlertNotification Service: Create AlertNotification- Success")
    public void createAlertNotificationTestSuccess() {
        BDDMockito.doReturn(mockResponseAlertNotication1).when(mockAlertNotificationRepo).save(ArgumentMatchers.any());
        Person returnedAlertNotification = alertNotificationService.create(inputAlertNotification);
        Assertions.assertNotNull(returnedAlertNotification, "AlertnNotification should not be null");
        Assertions.assertEquals(returnedAlertNotification.getId(), 1);
    }

    @Test
    @DisplayName("AlertNotification Service: Get Person by Id - Success")
    public void getAlertNotificationByIdTestSuccess() throws AlertNotificationNotFoundException {
        BDDMockito.doReturn(Optional.of(mockResponseAlertNotication1)).when(mockAlertRepo).findById("id");
        AlertNotification foundAlertNotification = alertNotificationService.getAlertNotificationByEmployeeNumber("number");
        Assertions.assertEquals(mockResponseAlertNotication1.toString(), foundAlertNotification.toString());
    }

    @Test
    @DisplayName(" Service: Get Widget by Id - Fail")
    public void getAlertNotificationByIdTestFailed() {
        BDDMockito.doReturn(Optional.empty()).when(mockAlertNotificationRepo).findById("id");
        Assertions.assertThrows(AlertNotificationNotFoundException.class, () -> {
            personService.getAlertNotificationsaByEmployeeNumber("id");
        });
    }

    @Test
    @DisplayName("AlertNotification Service: Get All Alerts - Success")
    public void getAllAlertNotificationTestSuccess(){
        List<AlertNotification> alerts = new ArrayList<>();
        alerts.add(mockResponseAlertNotification1);
        alerts.add(mockResponseAlertNotification2);

        BDDMockito.doReturn(alerts).when(mockAlertNotificationRepo).findAll();

        List<AlertNotification> responseAlerts = AlertNotificationService.getAllAlerts();
        Assertions.assertIterableEquals(alerts,responseAlerts);
    }

    @Test
    @DisplayName("AlertNotification Service: Update AlertNotification - Success")
    public void updatePersonTestSuccess() throws AlertNotificationNotFoundException {
        List<EmployeeNumber> numbers = new ArrayList<>();
        numbers.add(new EmployeeNumber("Part 1"));
        numbers.add(new EmployeeNumber("Part 2"));
        AlertNotification expectedAlertNotificationUpdate = new AlertNotification("id", numbers);

        BDDMockito.doReturn(Optional.of(mockResponseAlertNotification1)).when(mockAlertNotificationRepo).findById("id");
        BDDMockito.doReturn(expectedAlertNotificationUpdate).when(mockAlertNotificationRepo).save(ArgumentMatchers.any());

        AlertNotification actualAlertNotification = alertNotificationService.updateAlertNotification("id", expectedAlertNotificationUpdate);
        Assertions.assertEquals(expectedAlertNotificationUpdate.toString(), actualAlertNotification.toString());
    }

    @Test
    @DisplayName("AlertNotification Service: Update AlertNotification - Fail")
    public void updateAlertNotificationTestFail()  {
        List<EmployeeNumber> numbers = new ArrayList<>();
        numbers.add(new EmployeeNumber("Part 1"));
        numbers.add(new EmployeeNumber("Part 2"));
        AlertNotification expectedAlertNotificationUpdate = new Person("id",  numbers);
        BDDMockito.doReturn(Optional.empty()).when(mockAlertNotificationRepo).findById("id");
        Assertions.assertThrows(AlertNotificationNotFoundException.class, ()-> {
            alertNotificationService.updateAlertNotification("id", expectedAlertNotificationUpdate);
        });
    }

    @Test
    @DisplayName("AlertNotification Service: Delete Person - Success")
    public void deleteAlertNotificationTestSuccess() throws AlertNotificationNotFoundException {
        BDDMockito.doReturn(Optional.of(mockResponseAlertNotication1)).when(mockAlertRepo).findById("id");
        Boolean actualResponse = alertNotificationService.deleteAlertNotification("ID");
        Assertions.assertTrue(actualResponse);
    }

    @Test
    @DisplayName("AlertNotification Service: Delete AlertNotification - Fail")
    public void deleteAlertNotificationTestFail()  {
        BDDMockito.doReturn(Optional.empty()).when(mockAlertNotificationRepo).findById("id");
        Assertions.assertThrows(AlertNotificationNotFoundException.class, ()-> {
            alertNotificationService.deleteAlertNotification("MO");
        });
    }


}

}
