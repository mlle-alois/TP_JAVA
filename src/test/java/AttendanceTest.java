import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AttendanceTest {
  @Test
  void test1() {
    Attendance a = new Attendance(LocalTime.of(14,0,0), LocalTime.of(15,30,0));
    assertEquals(90, a.duration());
    assertEquals(14, a.startAt().getHour());
    assertEquals(15, a.endAt().getHour());
    assertEquals(30, a.endAt().getMinute());
  }

  @Test
  void test2() {
    Attendance a = new Attendance(LocalTime.of(16,0,0), LocalTime.of(15,30,0));
    assertEquals(0, a.duration());
    assertEquals(16, a.startAt().getHour());
    assertEquals(15, a.endAt().getHour());
    assertEquals(30, a.endAt().getMinute());
  }

  @Test
  void test3() {
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
