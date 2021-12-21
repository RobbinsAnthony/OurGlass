package Timestoppers.OurGlass.OurGlass.alertnotifications.controllers;


import Timestoppers.OurGlass.OurGlass.alertnotifications.services.AlertNotificationService;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AlertNotificationController extends BaseControllerTest {

@MockBean
private AlertNotificationService mockAlertNotificationService;

@Autowired
private MockMvc mockMvc;

private AlertNotification inputAlertNotification;
private AlertNotification mockResponseAlertNotication1;
private AlertNotification mockResponseAlertNotification2;

@BeforeEach
public void setUp() {

    mockResponseAlertNotication1 = new AlertNotification("Employee on task", id);
    mockResponseAlertNotication1.setId(121213131414);

    mockResponseAlertNotification2 = new AlertNotification("Employer on task", id);
    mockResponseAlertNotification2.setId(13131414131);
}
 @Test
 @DisplayAlertNotication("AlertNotification Post: /AlertNotification - success")
 public void createAlertNotificationRequestSuccess() throws Exception {
     BDDMockito.doReturn(mockResponseAlertNotication1).when(mockAlertNotificationService).create(any());

     mockMvc.perform(MockMvcRequestBuilders.post("/AlertNotification")
                     .contentType(MediaType.APPLICATION_JSON)
                     .content(asJsonString(inputAlertNotification)))

             .andExpect(MockMvcResultMatchers.status().isCreated())
             .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
             .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)))
             .andExpect(MockMvcResultMatchers.jsonPath("$.notification", Is.is("Test Alert notification 01")));
 }
}
