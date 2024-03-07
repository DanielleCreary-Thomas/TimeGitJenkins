import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

    @Test
    void getMillisecondsBad(){
        assertThrows(
                StringIndexOutOfBoundsException.class,
                ()->{Time.getMilliseconds("10:00:00");}
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"05:15:15:06", "12:05:05:06", "05:15:59:59" })
    void getMillisecondsGoodBoundary(String candidate)
    {
        int seconds = Time.getMilliseconds(candidate);
        if(candidate.equals("05:15:59:59")){
            assertTrue(seconds==59, "The milliseconds were calculated properly");
        }else{
            assertTrue(seconds==6, "The milliseconds were calculated properly");
        }
    }


    @Test
    void getTotalSecondsGood() {
        double seconds = Time.getTotalSeconds("05:05:05:05");
        assertTrue(seconds==18305, "The seconds were calculated properly");
    }

    @Test
    void getTotalSecondsBad() {
        assertThrows(
                StringIndexOutOfBoundsException.class,
                ()->{Time.getTotalSeconds("10:00");}
        );
    }

    @Test
    void getTotalSecondsBoundary() {
        double seconds = Time.getTotalSeconds("23:59:59:59");
        assertTrue(seconds==86399, "The seconds were calculated properly");
    }


    @Test
    void getSecondsBad() {
        assertThrows(
                StringIndexOutOfBoundsException.class,
                ()->{Time.getSeconds("10:00");}
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"05:15:15:15", "05:15:15:15", "05:15:59:59" })
    void getSecondsGoodBoundary(String candidate) {
        int seconds = Time.getSeconds(candidate);
        if(candidate.equals("05:15:59:59")){
            assertTrue(seconds==59, "The seconds were calculated properly");
        }else{
            assertTrue(seconds==15, "The seconds were calculated properly");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"05:15:00:00", "05:15:15:15", "05:59:59:59" })
    void getTotalMinutesGoodBoundary(String candidate) {
        int minutes = Time.getTotalMinutes(candidate);
        if(candidate.equals("05:59:59:59")){
            assertTrue(minutes==59, "The minutes were calculated properly");
        }else {
            assertTrue(minutes == 15, "The minutes were calculated properly");
        }
    }

    @Test
    void getTotalMinutesBad() {
        assertThrows(
                StringIndexOutOfBoundsException.class,
                ()->{Time.getTotalMinutes("10");}
        );
    }


    @Test
    void getTotalHoursBad() {
        assertThrows(
                StringIndexOutOfBoundsException.class,
                ()->{Time.getTotalHours("");}
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"05:00:00:00", "05:15:15:15", "23:59:59:59" })
    void getTotalHoursGoodBoundary(String candidate) {
        int hours = Time.getTotalHours(candidate);
        if(candidate.equals("23:59:59:59")){
            assertTrue(hours==23, "The hours were not calculated properly");
        }else {
            assertTrue(hours == 5, "The hours were not calculated properly");
        }
    }
}