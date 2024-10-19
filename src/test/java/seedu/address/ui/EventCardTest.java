package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import seedu.address.model.event.Event;
import seedu.address.model.event.EventDescription;
import seedu.address.model.event.EventDuration;
import seedu.address.model.event.EventName;

public class EventCardTest extends ApplicationTest {

    private Event event;
    private EventCard eventCard;

    @Override
    public void start(Stage stage) {
        event = new Event(new EventName("Meeting"), new EventDescription("Project discussion"),
                new EventDuration(LocalDate.parse("2024-01-01"), LocalDate.parse("2024-01-02")));
        eventCard = new EventCard(event, 1);

        StackPane root = new StackPane();
        root.getChildren().add(eventCard.getRoot());
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Test
    public void display() {
        // Wait for JavaFX thread to complete
        WaitForAsyncUtils.waitForFxEvents();

        // Verify that the event details are correctly displayed
        assertNotNull(eventCard);
        assertEquals("1. ", ((Label) eventCard.getRoot().lookup("#id")).getText());
        assertEquals("Meeting", ((Label) eventCard.getRoot().lookup("#eventName")).getText());
        assertEquals("Project discussion", ((Label) eventCard.getRoot().lookup("#eventDescription")).getText());
        assertEquals("From: 2024-01-01", ((Label) eventCard.getRoot().lookup("#eventFrom")).getText());
        assertEquals("To: 2024-01-02", ((Label) eventCard.getRoot().lookup("#eventTo")).getText());
    }
}
