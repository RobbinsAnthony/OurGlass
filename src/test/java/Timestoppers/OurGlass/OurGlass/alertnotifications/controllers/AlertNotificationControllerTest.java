package Timestoppers.OurGlass.OurGlass.alertnotifications.controllers;


import Timestoppers.OurGlass.OurGlass.alertnotifications.services.AlertNotificationService;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AlertNotificationControllerTest extends BaseControllerTest {

@MockBean
private AlertNotificationService mockAlertNotificationService;

@Autowired
private MockMvc mockMvc;

private AlertNotification inputAlertNotification;
private AlertNotification mockResponseAlertNotication1;
private AlertNotification mockResponseAlertNotification2;

@BeforeEach
public void setUp() {
    List<EmployeeNumber> number = new ArrayList();
    number.add(new EmployeeNumber(131213));
    number.add(new EmployeeNumber(112233));
    inputAlertNotification = new AlertNotificaiton(1223232,number);

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


    @Test
    @DisplayName("GET /alertNotification/1 - Found")
    public void getAlertNotificationByIdTestSuccess() throws Exception{
        BDDMockito.doReturn(mockResponseAlertNotication1).when(mockAlertNotificationService).getAlertNotificationByEmployeeNumber(123214);

        mockMvc.perform(get("/AlertNotification/{id}", 14433))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.alert", is("Test AlertNotification 01")));
    }

    @Test
    @DisplayName("GET /AlertNotification/1 - Not Found")
    public void getAlertNotificationByIdTestFail() throws Exception {
        BDDMockito.doThrow(new AlertNotificationNotFoundException("Not Found")).when(mockAlertNotificationService).getAlertNotificationByEmployeeNumber(12443);
        mockMvc.perform(get("/alertNotification/{id}", 19988))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("PUT /alertNotification/1 - Success")
    public void putAlertNotificationTestNotSuccess() throws Exception{
        List<EmployeeNumber> number = new ArrayList<>();
        number.add(new EmployeeNumber("number "));
        number.add(new EmployeeNumber("number"));
        Person expectedAlertNotificationUpdate = new AlertNotification("id", number);
        expectedAlertNotificationUpdate.setId(14433);
        BDDMockito.doReturn(expectedAlertNotificationUpdate).when(mockAlertNotificationService).updateAlertNotification(any(), any());
        mockMvc.perform(put("/alertNotification/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(inputPerson)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.number", is("After Update employee number")));
    }

    @Test
    @DisplayName("PUT /alertNotification/1 - Not Found")
    public void putAlertNotificationTestNotFound() throws Exception{
        BDDMockito.doThrow(new PersonNotFoundException("Not Found")).when(mockAlertNotificationService).updateAlertNotification(any(), any());
        mockMvc.perform(put("/alertNotification/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(inputAlerNotification)))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("DELETE /alertNotification/1 - Success")
    public void deleteAlertNotificationTestNotSuccess() throws Exception{
        BDDMockito.doReturn(true).when(mockAlertNotificationService).deleteAlertNotification(any());
        mockMvc.perform(delete("/alertNotification/{id}", 1))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("DELETE /alertNotification/1 - Not Found")
    public void deleteAlertNotificationTestNotFound() throws Exception{
        BDDMockito.doThrow(new AlertNotificationNotFoundException("Not Found")).when(mockAlertNotificationService).deleteAlertNotification(any());
        mockMvc.perform(delete("/alertNotification/{id}", 1))
                .andExpect(status().isNotFound());
    }
}



