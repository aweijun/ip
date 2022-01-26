package duke.duke.task;

import main.java.duke.task.Deadline;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    @Test
    void test_toStore() {
        assertEquals("D | 0 | name | 2/12/2019 1800", new Deadline("name","2/12/2019 1800" ).toStore());
    }
    @Test
    void test_display() {
        assertEquals("[D] [ ] name (by Dec 2 2019)", new Deadline("name","2/12/2019 1800" ).display());
    }
}
