import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SessionTest {

  @Test
  void check_that_session_is_well_created() {
    Session s = new Session( "test", LocalTime.of( 14, 0, 0), LocalTime.of( 16, 0, 0));
    assertTrue( s.startAt().isBefore( s.endAt()));
    assertEquals(14, s.startAt().getHour());
    assertEquals(16, s.endAt().getHour());
  }

  @Test
  void check_that_session_is_well_created_even_if_I_swap_start_and_end() {
    Session s = new Session( "test", LocalTime.of( 16, 0, 0), LocalTime.of( 14, 0, 0));
    assertTrue( s.startAt().isBefore( s.endAt()));
    assertEquals(14, s.startAt().getHour());
    assertEquals(16, s.endAt().getHour());
  }
}
