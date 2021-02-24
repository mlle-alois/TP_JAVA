import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Attendance {

    private LocalTime heureConnexion;
    private LocalTime heureDeconnexion;

    public Attendance(LocalTime heureConnexion, LocalTime heureDeconnexion) {
        this.heureConnexion = heureConnexion;
        this.heureDeconnexion = heureDeconnexion;
    }

    public LocalTime startAt(){
        return this.heureConnexion;
    }

    public LocalTime endAt(){
        return this.heureDeconnexion;
    }

    public int duration() {
        if( heureConnexion.isAfter( heureDeconnexion)){
            return 0;
        }
        return (int) heureConnexion.until(heureDeconnexion, ChronoUnit.MINUTES);
    }

    public Attendance bounded(Session session) {
        return new Attendance(session.startAt(), session.endAt());
    }

    @Override
    public boolean equals(Object other) {
        Attendance otherAttendence = (Attendance) other;
        if(otherAttendence.startAt().equals(this.startAt()) && otherAttendence.endAt().equals(this.endAt())) {
            return true;
        }
        else {
            return false;
        }
    }

}
