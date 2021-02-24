import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AttendeeTest {

  @Test
  void test1() {
    // TODO : Given a session from 17:00 to 18:00, if Bob is connected from 17:01 to 17:59, then he spent 58 minutes in class
    Session s = new Session("test", LocalTime.of(17,0,0), LocalTime.of(18,0,0));
    List<Attendance> l = new ArrayList<>();
    l.add(new Attendance(LocalTime.of(17,1,0), LocalTime.of(17,59,0)));
    Attendee a = new Attendee("Bob", l);
    assertEquals(58, a.timeSpent(s));
  }
  @Test
  void test2() {
    // TODO : Given a session from 17h00 to 18h00, if Bob is connected from 16h01 to 16h59, then he spent 0 minutes in class
    Session s = new Session("test", LocalTime.of(17,0,0), LocalTime.of(18,0,0));
    List<Attendance> l = new ArrayList<>();
    l.add(new Attendance(LocalTime.of(16,1,0), LocalTime.of(16,59,0)));
    Attendee a = new Attendee("Bob", l);
    assertEquals(0, a.timeSpent(s));
  }
  @Test
  void test3() {
    // TODO : Given a session from 17h00 to 18h00, if Bob is connected from 18h01 to 18h59, then he spent 0 minutes in class
    Session s = new Session("test", LocalTime.of(17,0,0), LocalTime.of(18,0,0));
    List<Attendance> l = new ArrayList<>();
    l.add(new Attendance(LocalTime.of(18,1,0), LocalTime.of(18,59,0)));
    Attendee a = new Attendee("Bob", l);
    assertEquals(0, a.timeSpent(s));
  }
  @Test
  void test4() {
    // TODO : Given a session from 17h00 to 18h00, if Bob is connected from 17h10 to 17h20 and from 17h30 to 17h45, then he spent 25 minutes in class
    Session s = new Session("test", LocalTime.of(17,0,0), LocalTime.of(18,0,0));
    List<Attendance> l = new ArrayList<>();
    l.add(new Attendance(LocalTime.of(17,10,0), LocalTime.of(17,20,0)));
    l.add(new Attendance(LocalTime.of(17,30,0), LocalTime.of(17,45,0)));
    Attendee a = new Attendee("Bob", l);
    assertEquals(25, a.timeSpent(s));
  }
  @Test
  void test5() {
    // TODO : Given a session from 17h00 to 18h00, if Bob is connected from 17h30 to 18h45, then he spent 30 minutes in class
    Session s = new Session("test", LocalTime.of(17,0,0), LocalTime.of(18,0,0));
    List<Attendance> l = new ArrayList<>();
    l.add(new Attendance(LocalTime.of(17,30,0), LocalTime.of(18,45,0)));
    Attendee a = new Attendee("Bob", l);
    assertEquals(30, a.timeSpent(s));
  }
  @Test
  void test6() {
    // TODO : Given a session from 17h00 to 18h00, if Bob is connected from 16h30 to 17h30, then he spent 30 minutes in class
    Session s = new Session("test", LocalTime.of(17,0,0), LocalTime.of(18,0,0));
    List<Attendance> l = new ArrayList<>();
    l.add(new Attendance(LocalTime.of(16,30,0), LocalTime.of(17,30,0)));
    Attendee a = new Attendee("Bob", l);
    assertEquals(30, a.timeSpent(s));
  }
  @Test
  void test7() {
    // TODO : Given a session from 17h00 to 18h00, if Bob is connected from 17h30 to 18h00, then he was late
    Session s = new Session("test", LocalTime.of(17,0,0), LocalTime.of(18,0,0));
    List<Attendance> l = new ArrayList<>();
    l.add(new Attendance(LocalTime.of(17,30,0), LocalTime.of(18,0,0)));
    Attendee a = new Attendee("Bob", l);
    assertTrue(a.wasLate(s));
  }
  @Test
  void test8() {
    // TODO : Given a session from 17h00 to 18h00, if Bob is connected from 17h30 to 17h40, then he was late
    Session s = new Session("test", LocalTime.of(17,0,0), LocalTime.of(18,0,0));
    List<Attendance> l = new ArrayList<>();
    l.add(new Attendance(LocalTime.of(17,30,0), LocalTime.of(17,40,0)));
    Attendee a = new Attendee("Bob", l);
    assertTrue(a.wasLate(s));
  }
  @Test
  void test9() {
    // TODO : Given a session from 17h00 to 18h00, if Bob was not connected at all, then he was absent
    Session s = new Session("test", LocalTime.of(17,0,0), LocalTime.of(18,0,0));
    List<Attendance> l = new ArrayList<>();
    Attendee a = new Attendee("Bob", l);
    assertTrue(a.wasAbsent(s));
  }
  @Test
  void test10() {
    // TODO : Given a session from 17h00 to 18h00, if Bob is connected from 17h00 to 17h05 and from 17h55 and 18h00, then he was absent
    Session s = new Session("test", LocalTime.of(17,0,0), LocalTime.of(18,0,0));
    List<Attendance> l = new ArrayList<>();
    l.add(new Attendance(LocalTime.of(17,0,0), LocalTime.of(17,5,0)));
    l.add(new Attendance(LocalTime.of(17,55,0), LocalTime.of(18,0,0)));
    Attendee a = new Attendee("Bob", l);
    assertTrue(a.wasAbsent(s));
  }
}