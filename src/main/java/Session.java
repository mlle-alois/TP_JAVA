import java.time.LocalTime;

public class Session {
    private String name;
    private LocalTime start;
    private LocalTime end;

    public Session( String name, LocalTime start, LocalTime end ){
        this.name = name;
        if( start.isBefore( end )){
            this.start = start;
            this.end = end;
        } else {
            this.start = end;
            this.end = start;
        }
    }

    public LocalTime startAt(){
        return this.start;
    }

    public LocalTime endAt(){
        return this.end;
    }
}
