import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AttendanceTest {
  @Test
  void test1() {
    // TODO : The duration of an attendance starting at 14:00 and finishing at 15:30 should be 90 minutes
    Attendance a = new Attendance(LocalTime.of(14,0,0), LocalTime.of(15,30,0));
    assertEquals(90, a.duration());
    assertEquals(14, a.startAt().getHour());
    assertEquals(15, a.endAt().getHour());
    assertEquals(30, a.endAt().getMinute());
  }

  @Test
  void test2() {
    // TODO : The duration of an attendance starting at 16:00 and finishing at 15:30 should be 0 minutes
    Attendance a = new Attendance(LocalTime.of(16,0,0), LocalTime.of(15,30,0));
    assertEquals(0, a.duration());
    assertEquals(16, a.startAt().getHour());
    assertEquals(15, a.endAt().getHour());
    assertEquals(30, a.endAt().getMinute());
  }

  @Test
  void test3() {
    // TODO : If I bound an attendance from 14h30 to 15h30 with a session from 14h00 to 15h00, then I should get a new Attendance between 14h30 and 15h30
    Session s = new Session( "test", LocalTime.of( 14, 0, 0), LocalTime.of( 15, 0, 0));
    Attendance a = new Attendance(LocalTime.of(14,30,0), LocalTime.of(15,30,0));
    Attendance newAttendance = a.bounded(s);
    assertEquals(14, a.startAt().getHour());
    assertEquals(30, a.startAt().getMinute());
    assertEquals(15, a.endAt().getHour());
    assertEquals(30, a.endAt().getMinute());
    assertEquals(60, a.duration());
  }

  @Test
  void test4() {
    Attendance a = new Attendance(LocalTime.of(14,30,0), LocalTime.of(15,30,0));
    Attendance a2 = new Attendance(LocalTime.of(14,30,0), LocalTime.of(15,30,0));
    assertTrue(a.equals(a2));
  }
}
