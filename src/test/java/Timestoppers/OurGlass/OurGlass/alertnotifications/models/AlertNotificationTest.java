package Timestoppers.OurGlass.OurGlass.alertnotifications.models;

import Timestoppers.OurGlass.OurGlass.alertnotifications.repos.AlertNotificationRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlertNotificationTest {
    private AlertNotification alertNotification1;
    private AlertNotification alertNotification2;

    private AlertNotification emptyAlertNotification1;
    private AlertNotification getEmptyAlertNotification2;

    @BeforeEach
    public void setUp() {
        emptyAlertNotification1 = new AlertNotification();
        emptyAlertNotification2 = new AlertNotification();

        List<EmployeeNumber> number = new ArrayList<>();
        number.add(new EmployeeNumber("Number 543"));
        number.add(new EmployeeNumber("Number 544"));

        alertNotification1 = new AlertNotification("id", number);
        alertNotification1.setId(1332);

        alertNotification2 = new AlertNotification("id", number);
        alertNotification2.setId(22244);
    }

    @Test
    public void testEmptyEquals() throws Exception {

        assertTrue(
                emptyAlertNotification1.equals(emptyAlertNotification2),
                "Both empty AlertNotification instances should be equal");
    }

    @Test
    public void testContentEquals() throws Exception {

        assertTrue(
                alertNotification1.equals(alertNotification2),
                "Both non-empty AlertNotification instances should be equal");
    }

    @Test
    public void testNotEquals() throws Exception {

        assertFalse(
                emptyAlertNotification1.equals(alertNotification2),
                "The AlertNotification instances should not be equal");
    }

    @Test
    public void testEmptyHashCode() throws Exception {

        assertEquals(
                emptyAlertNotification1.hashCode(),
                getEmptyAlertNotification2.hashCode(),
                "Both empty AlertNotification instances should have the same hashCode");
    }

    @Test
    public void testContentHashCode() throws Exception {

        assertEquals(
                alertNotification1.hashCode(),
                alertNotification2.hashCode(),
                "Both non-empty AlertNotification instances should have the same hashCode");
    }

    @Test
    public void testHashCode() throws Exception {

        assertNotEquals(
                emptyAlertNotification1.hashCode(),
                AlertNotification2.hashCode(),
                "The AlertNotification instances should not have the same hashCode");
    }

    @Test
    public void testEmptyToString() throws Exception {

        assertEquals(
                emptyAlertNotification1.toString(),
                getEmptyAlertNotification2.toString(),
                "Both empty AlertNotification instances should have the same toString");
    }

    @Test
    public void testContentToString() throws Exception {

        assertEquals(
                alertNotification1.toString(),
                alertNotification2.toString(),
                "Both non-empty AlertNotification instances should have the same toString");
    }

    @Test
    public void testNotToString() throws Exception {

        assertNotEquals(
                emptyAlertNotification1.toString(),
                alertNotification2.toString(),
                "The AlertNotification instances should not have the same toString");
    }
}


}
