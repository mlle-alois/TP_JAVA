import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class SessionTest {

  @Test
  void check_that_session_is_well_created() {
    Session s = new Session( "test", LocalTime.of( 14, 0, 0), LocalTime.of( 15, 0, 0));

  }

  @Test
  void check_that_session_is_well_created_even_if_I_swap_start_and_end() {
    // TODO: If I create a Session 'math' between 16:00 and 14:00, then It should start at 14:00 and finish at 16:00
  }
}
